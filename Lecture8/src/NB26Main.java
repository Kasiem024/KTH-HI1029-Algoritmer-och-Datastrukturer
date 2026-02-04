public class NB26Main {
    public static void main(String[] args) {
        HashTableBucket<Integer, Integer> testMap = new HashTableBucket<>(5);
        int numElements = 50;

        System.out.println("Lägger till " + numElements + " element...");
        for (int i = 0; i < numElements; i++) {
            testMap.put(i, i * 10);
        }

        boolean allFound = true;
        for (int i = 0; i < numElements; i++) {
            Integer val = testMap.get(i);
            if (val == null || val != i * 10) {
                allFound = false;
                System.out.println("FEL: Hittade inte nyckel " + i);
            }
        }

        System.out.println("Status: " + (allFound ? "SUCCESS" : "FAILED"));
        System.out.println("Slutgiltig tabellstruktur:");
        System.out.println(testMap);
    }
}
