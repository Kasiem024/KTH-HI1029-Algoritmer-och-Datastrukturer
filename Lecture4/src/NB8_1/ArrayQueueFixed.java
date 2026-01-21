package NB8_1;

public class ArrayQueueFixed<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    public ArrayQueueFixed(int initialSize) {
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element) {
        if (size == maxSize)
            reallocate();
        data[rear] = element;
        // FIX: Parenteser runt (rear + 1) för korrekt matte
        rear = (rear + 1) % maxSize;
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) return null;
        return data[front];
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            // FIX: Parenteser runt (front + 1)
            front = (front + 1) % maxSize;
            return element;
        }
    }

    private void reallocate() {
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];

        // FIX: Manuell kopiering krävs för att "räta ut" kön
        // Arrays.copyOf fungerar inte om kön har snurrat runt
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % maxSize];
        }

        data = newData;
        front = 0;
        rear = size;
        maxSize = newMaxSize;
    }

    // TILLÄGG: Enligt instruktion
    public String toString() {
        return "Queue[size=" + size + ", front=" + front + ", rear=" + rear + "]";
    }
}