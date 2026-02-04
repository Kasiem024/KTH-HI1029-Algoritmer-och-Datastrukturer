public class NB23_1<E extends Comparable<E>> {

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

    public E find(E target) {
        Node<E> current = root;
        while (current != null) {
            int comp = target.compareTo(current.data);
            if (comp == 0) return current.data;
            else if (comp < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public E maxRec() {
        if (root == null) return null;
        return maxRec(root);
    }

    private E maxRec(Node<E> node) {
        if (node.right == null) return node.data;
        return maxRec(node.right);
    }

    public E maxIt() {
        if (root == null) return null;
        Node<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public static void main(String[] args) {
        NB23_1<Integer> tree = new NB23_1<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(20);

        System.out.println("Find 15: " + tree.find(15));
        System.out.println("Find 99: " + tree.find(99));
        System.out.println("Max Rec: " + tree.maxRec());
        System.out.println("Max It:  " + tree.maxIt());
    }
}