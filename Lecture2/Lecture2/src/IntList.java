import java.util.Arrays;

public class IntList {
    private int[] intArray;
    private int nrElements;
    private int maxSize;

    public IntList(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("Error! initialCapacity cannot be 0 or less!");
        this.nrElements = 0;
        this.maxSize = initialCapacity;
        this.intArray = new int[initialCapacity];
    }

    public void reallocate() {
        maxSize *= 2;
        intArray = Arrays.copyOf(intArray, maxSize);
    }

    public void add(int element) {
        if (nrElements == maxSize) reallocate();
        intArray[nrElements] = element;
        nrElements++;
    }

    public void add(int index, int element) {
        if (index < 0 || index > nrElements) throw new ArrayIndexOutOfBoundsException(index);
        if (nrElements == maxSize) reallocate();

        for (int i = nrElements; i > index; i--) {
            intArray[i] = intArray[i-1];
        }

        intArray[index] = element;
        nrElements++;
    }

    public int get(int index) {
        if (index < 0 || index >= nrElements) throw new ArrayIndexOutOfBoundsException(index);
        return intArray[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < nrElements; i++) {
            if (intArray[i] == element) return i;
        }
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= nrElements) throw new ArrayIndexOutOfBoundsException(index);

        int oldValue = intArray[index];

        for (int i = index; i < nrElements - 1; i++) {
            intArray[i] = intArray[i + 1];
        }
        nrElements--;
        return oldValue;
    }

    public int set(int index, int element) {
        if (index < 0 || index >= nrElements) throw new ArrayIndexOutOfBoundsException(index);

        int oldValue = intArray[index];

        intArray[index] = element;

        return oldValue;
    }

    public int size() {
        return nrElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nrElements; i++) {
            sb.append(intArray[i]);
            if (i < nrElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
