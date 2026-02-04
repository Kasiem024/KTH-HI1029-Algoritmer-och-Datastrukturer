package NB24;

public class NB24Main {
    public static void main(String[] args) {
        HashTableBucket<Integer, String> table = new HashTableBucket<>(10);

        table.put(1, "Ett");
        table.put(11, "Elva");
        table.put(21, "Tjugoett");

        System.out.println("Kollar innehåll:");
        System.out.println(table);

        System.out.println("Hämtar 11: " + table.get(11));

        System.out.println("Tar bort 99 (finns ej): " + table.remove(99));

        table.remove(11);
        System.out.println("Efter att 11 tagits bort:");
        System.out.println(table);
    }
}
