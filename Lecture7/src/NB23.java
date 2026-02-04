public class NB23<E extends Comparable<E>> {

    private Node<E> root;

    private static class Node<E> {
        E data;
        Node<E> left, right;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E data) {
        root = add(root, data);
    }

    private Node<E> add(Node<E> node, E data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0) node.left = add(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = add(node.right, data);
        return node;
    }

    public int numberOfNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<E> node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int numberOfLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int height() {
        return calcHeight(root);
    }

    private int calcHeight(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
    }

    public static void main(String[] args) {
        NB23<Integer> bst = new NB23<>();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);

        System.out.println("Nodes: " + bst.numberOfNodes());
        System.out.println("Leaves: " + bst.numberOfLeaves());
        System.out.println("Height: " + bst.height());
    }
}