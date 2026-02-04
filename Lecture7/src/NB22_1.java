import java.util.LinkedList;
import java.util.Queue;

public class NB22_1<E extends Comparable<E>> {

    private static class Node<E> {
        E data;
        Node<E> left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> root;

    public void add(E data) {
        root = add(root, data);
    }

    private Node<E> add(Node<E> node, E data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0) node.left = add(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = add(node.right, data);
        return node;
    }

    public void printTree() {
        if (root == null) return;
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node<E> curr = q.poll();
                if (curr != null) {
                    System.out.print(curr.data + " ");
                    q.offer(curr.left);
                    q.offer(curr.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NB22_1<String> tree = new NB22_1<>();
        tree.add("H");
        tree.add("B");
        tree.add("N");
        tree.add("A");
        tree.add("E");
        tree.add("C");
        tree.add("F");
        tree.add("D");

        tree.printTree();
    }
}