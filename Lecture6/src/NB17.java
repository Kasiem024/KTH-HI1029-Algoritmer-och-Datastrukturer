public class NB17 {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        System.out.println(list.size());
        System.out.println(list.getNode(1));
    }
}

class SingleLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public SingleLinkedList() {
        head = null;
    }

    public void addFirst(E item) {
        head = new Node<>(item, head);
    }

    public E getNode(int index) {
        return getNodeRecursive(head, index);
    }

    private E getNodeRecursive(Node<E> node, int index) {
        if (node == null) return null;
        if (index == 0) return node.data;
        return getNodeRecursive(node.next, index - 1);
    }

    public int size() {
        return sizeRecursive(head);
    }

    private int sizeRecursive(Node<E> node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }
}