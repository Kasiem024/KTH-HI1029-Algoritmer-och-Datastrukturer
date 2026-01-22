public class NB11 {
    public static void main(String[] args) {

        int[] array = {40, 55, 63, 17, 22, 100};

        System.out.println(findBiggest(array, array[0], 0));
    }

    private static int findBiggest(int[] array, int biggest, int index) {
        if (index == array.length) return biggest;
        if (biggest < array[index]) biggest = array[index];
        return findBiggest(array, biggest, index + 1);
    }
}
