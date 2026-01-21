package NB10;

public class NB10<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public NB10() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean offerLast(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            front = node;
        } else {
            rear.next = node;
            node.prev = rear;
        }
        rear = node;
        size++;
        return true;
    }

    public boolean offerFirst(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            rear = node;
        } else {
            front.prev = node;
            node.next = front;
        }
        front = node;
        size++;
        return true;
    }

    public E pollLast() {
        if (size == 0) {
            return null;
        }
        E element = rear.data;
        rear = rear.prev;

        if (rear == null) front = null;
        else rear.next = null;

        size--;
        return element;
    }

    public E pollFirst() {
        if (size == 0) {
            return null;
        }

        E element = front.data;

        front = front.next;

        if (front == null) rear = null;
        else front.prev = null;

        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
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