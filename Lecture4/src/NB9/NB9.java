package NB9;

public class NB9<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public NB9() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean offer(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        size++;
        return true;
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        E element = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return element;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}