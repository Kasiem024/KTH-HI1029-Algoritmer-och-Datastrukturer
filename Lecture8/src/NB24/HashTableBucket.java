package NB24;

import java.util.Iterator;
import java.util.Objects;

public class HashTableBucket<K, V> {
    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new SingleLinkedList[initialSize];
    }

    public V get(K key) {
        int index = getIndex(key);

        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);

        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].addFirst(new Entry<>(key, value));
        return null;
    }

    private int getIndex(K key) {
        int index = key.hashCode() % table.length;
        return (index < 0) ? index + table.length : index;
    }

    public V remove(K key) {
        int index = getIndex(key);

        if (table[index] == null) {
            return null;
        }

        Iterator<Entry<K, V>> it = table[index].iterator();
        while (it.hasNext()) {
            Entry<K, V> current = it.next();
            if (Objects.equals(current.key, key)) {
                V valueToReturn = current.value;
                it.remove();
                return valueToReturn;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--- HashTable Status ---\n");
        for (int i = 0; i < table.length; i++) {
            sb.append(String.format("Index %2d: ", i));

            if (table[i] == null || table[i].isEmpty()) {
                sb.append("<empty>");
            } else {
                for (Entry<K, V> entry : table[i]) {
                    sb.append(" -> {").append(entry.key).append(":").append(entry.value).append("}");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}