package NB8;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

public class ArrayQueue<E> extends AbstractQueue<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialMaxSize) {
        size = 0;
        front = 0;
        maxSize = initialMaxSize;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean offer(E element) {
        if (size == maxSize) {
            reallocate();
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    @Override
    public E poll() {
        if (size == 0) return null;

        size--;
        E element = data[front];
        front = (front + 1) % maxSize;

        if (((double) size / maxSize) <= 0.25) shrink();
        return element;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newMaxSize = 2 * maxSize;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;

        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }

        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }

    @Override
    public int size() {
        return size;
    }

    public void shrink() {
        if (((double) size / maxSize) > 0.25) throw new IllegalStateException();
        if (maxSize <= 1) return;


        int newMaxSize = maxSize / 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;

        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }

        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count = 0;

        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E returnValue = data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}