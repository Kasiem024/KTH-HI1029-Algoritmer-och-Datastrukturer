import java.util.Arrays;
import java.util.Random;

public class Uppgift9 {

    // Main method for Radix Sort
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        // Find max value to determine number of digits
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Run Counting Sort for each digit position
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Stable Counting Sort for specific digit position
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of digits 0 to 9
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Convert count to actual positions in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array backwards to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output back to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int size = 1000000;
        int[] data = new int[size];
        Random rand = new Random();

        // Fill with one million random positive integers
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        System.out.println("Starting sort of " + size + " integers...");
        long startTime = System.currentTimeMillis();

        radixSort(data);

        long endTime = System.currentTimeMillis();
        System.out.println("Sorting finished in: " + (endTime - startTime) + " ms");

        // Verify that the sorting is correct
        boolean success = true;
        for (int i = 0; i < size - 1; i++) {
            if (data[i] > data[i + 1]) {
                success = false;
                break;
            }
        }
        System.out.println("Sort successful: " + success);
    }
}