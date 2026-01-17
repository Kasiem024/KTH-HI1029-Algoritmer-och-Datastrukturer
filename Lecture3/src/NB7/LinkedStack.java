package NB7;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E> {
    private static class Node<E> {
        private final E data;
        private final Node<E> next;

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    public E peek(int n) {
        if (empty()) throw new EmptyStackException();
        if (n >= size()) throw new IllegalArgumentException("n is out of bounds");

        Node<E> head = top;

        for (int i = 0; i < n; i++) {
            head = head.next;
            if (head == null) throw new EmptyStackException();
        }

        return head.data;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public int size() {
        Node<E> head = top;
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }

    public E flush() {
        if (empty()) throw new EmptyStackException();

        for (int i = 0; i < size() + 1; i++) top = top.next;

        return pop();
    }
}