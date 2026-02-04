package NB26_1;

import NB25.HashTableBucket;

public class NB26_1Main {
    public static void main(String[] args) {
        String[] strings = {"man", "gråter", "när", "man", "tänker", "när", "man"};

        System.out.println(occurrence(strings));
    }

    private static int occurrence(String[] arr) {
        int counter = 0;

        HashTableBucket<String, Integer> hash = new HashTableBucket<>(10);

        for (String s : arr) {

            Integer temp = hash.get(s);

            if (temp != null) {
                temp++;
                hash.put(s, temp);
            } else {
                temp = 1;
                hash.put(s, temp);
            }

            counter = Math.max(counter, temp);
        }
        return counter;
    }
}
