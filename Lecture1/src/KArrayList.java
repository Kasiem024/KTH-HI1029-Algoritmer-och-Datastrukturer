import java.util.Arrays;

public class KArrayList<E> {
    private E[] data;
    private int nrElements;
    private int maxSize;

    public KArrayList() {
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element) {
        if (nrElements == maxSize)
            reallocate();
        data[nrElements++] = element;
        return true;
    }

    public void add(int index, E element) {
        if (0 <= index && index <= nrElements) {
            if (nrElements == maxSize)
                reallocate();
            for (int i = nrElements; i > index; i--)
                data[i] = data[i - 1];
            data[index] = element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E get(int index) {
        if (0 <= index && index < nrElements)
            return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nrElements; i++) {
            sb.append(data[i]);
            if (i < nrElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public E remove(int index) {
        if (index < 0 || index >= nrElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = data[index];
        for (int i = index; i < nrElements - 1; i++) {
            data[i] = data[i + 1];
        }
        nrElements--;
        return oldValue;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < nrElements; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public E set(int index, E element){
        if (index < 0 || index >= nrElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = data[index];
        data[index] = element;
        return oldValue;
    }
}