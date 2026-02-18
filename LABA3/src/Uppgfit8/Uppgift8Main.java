package Uppgfit8;

public class Uppgift8Main {
    public static void main(String[] args) {
        Map<Integer, String> tree = new Map<>();

        // Build the balanced tree from the assignment image
        // To keep it balanced, we add the middle element first
        tree.put(5, "Five");
        tree.put(2, "Two");
        tree.put(1, "One");
        tree.put(8, "Eight");
        tree.put(12, "Twelve");

        System.out.println("Tree content: " + tree);

        // Testing cases from the assignment description
        System.out.println("Next larger than 2: " + tree.getNextLarger(2)); // Should be 5
        System.out.println("Next larger than 3: " + tree.getNextLarger(3)); // Should be 5
        System.out.println("Next larger than 4: " + tree.getNextLarger(4)); // Should be 5

        System.out.println("Next larger than 5: " + tree.getNextLarger(5)); // Should be 8
        System.out.println("Next larger than 6: " + tree.getNextLarger(6)); // Should be 8
        System.out.println("Next larger than 7: " + tree.getNextLarger(7)); // Should be 8

        System.out.println("Next larger than 12: " + tree.getNextLarger(12)); // Should be null
        System.out.println("Next larger than 15: " + tree.getNextLarger(15)); // Should be null
    }
}