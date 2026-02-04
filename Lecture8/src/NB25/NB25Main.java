package NB25;

import NB24.HashTableBucket;

public class NB25Main {
    public static void main(String[] args) {
        HashTableBucket<String, Integer> map = new HashTableBucket<>(2);

        System.out.println("test1");
        map.put("test1", 100);
        map.put("test2", 200);
        System.out.println(map);

        map.put("test3", 300);
        System.out.println("efter rehash");
        System.out.println(map);

        map.put("test4", 400);
        map.put("test5", 500);
        System.out.println("slutgiltig:");
        System.out.println(map);
    }
}
