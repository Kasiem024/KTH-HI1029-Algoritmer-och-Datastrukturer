public class NB26_3Main {
    public static void main(String[] args) {

        HashTableBucket<Integer, String> table = new HashTableBucket<>(10);

        table.put(1, "Ett");
        table.put(11, "Elva");
        table.put(21, "Tjugoett");

        System.out.println("Kollar innehåll:");
        System.out.println(table);

        System.out.println("Hämtar 11: " + table.get(1));
        System.out.println("Hämtar 11: " + table.get(11));
        System.out.println("Hämtar 11: " + table.get(21));

        System.out.println("Tar bort 99 (finns ej): " + table.remove(99));

        table.remove(11);
        System.out.println("Efter att 11 tagits bort:");
        System.out.println(table);

    }

    public static class HashTableBucket<K, V> {
        private static class Entry<K, V> {

            public K key;
            public V value;

            public Entry(K k, V v) {
                key = k;
                value = v;
            }
        }

        private Entry<K, V>[] table;
        private Entry<K, V> DELETED = new Entry<>(null, null);
        private int size = 0;

        @SuppressWarnings("unchecked")
        public HashTableBucket(int initialSize) {
            table = new Entry[initialSize];
        }

        public V get(K key) {
            int index = key.hashCode() % table.length;
            if (index < 0) index += table.length;

            int startIndex = index;

            while (table[index] != null) {
                if (table[index].key.equals(key)) {
                    return table[index].value;
                }

                index = (index + 1) % table.length;

                if (index == startIndex) {
                    return null;
                }
            }

            return null;
        }

        public V put(K key, V value) {
            if (size >= table.length * 0.75) {
                rehash();
            }

            int index = key.hashCode() % table.length;
            if (index < 0) index += table.length;

            while (table[index] != null) {
                if (table[index] != DELETED && table[index].key.equals(key)) {
                    V oldValue = table[index].value;
                    table[index].value = value;
                    return oldValue;
                }

                index = (index + 1) % table.length;
            }

            table[index] = new Entry<>(key, value);
            size++;
            return null;
        }

        public V remove(K key) {
            int index = key.hashCode() % table.length;
            if (index < 0) index += table.length;

            int startIndex = index;

            while (table[index] != null) {
                if (table[index] != DELETED && table[index].key.equals(key)) {
                    V oldValue = table[index].value;

                    table[index] = DELETED;
                    size--;

                    return oldValue;
                }

                index = (index + 1) % table.length;

                if (index == startIndex) {
                    return null;
                }
            }
            return null;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            Entry<K, V>[] oldTable = table;

            // Dubbla storleken
            table = new Entry[oldTable.length * 2];
            size = 0;

            for (Entry<K, V> e : oldTable) {
                if (e != null && e != DELETED) {
                    put(e.key, e.value);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("--- HashTable Status ---\n");
            for (int i = 0; i < table.length; i++) {
                sb.append(String.format("Index %2d: ", i));
                if (table[i] == null) {
                    sb.append("<empty>");
                } else {
                    Entry<K, V> temp = table[i];
                    sb.append(" -> {").append(temp.key).append(":").append(temp.value).append("}");

                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
