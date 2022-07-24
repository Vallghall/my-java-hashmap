package MyHashMap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap <K,V> {
    static class Entry <K,V> {
        final K key;
        V value;
        Entry<K,V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    static int capacity = 1 << 10;
    List<Entry<K,V>> bucket;
    int size;
    MyHashMap() {
        this.bucket = new ArrayList<>();
        while (this.bucket.size() < capacity)
            this.bucket.add(null);
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = key.hashCode() % capacity;
        Entry<K,V> n = this.bucket.get(index);
        if (n == null) {
            this.bucket.add(index, new Entry<K, V>(key, value));
            this.size++;
            return;
        }

        if (n.key.equals(key)) {
            n.value = value;
            return;
        }

        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next.value = value;
                return;
            }
            n = n.next;
        }
        n.next = new Entry<K, V>(key, value);
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;
        Entry<K,V> n = this.bucket.get(index);

        while (n != null) {
            if (n.key.equals(key))
                return n.value;
            n = n.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % capacity;
        Entry<K,V> n = this.bucket.get(index);
        if (n == null)
            return;

        if (n.key.equals(key)) {
            this.bucket.set(index, n.next);
            return;
        }

        Entry<K,V> prv = n;
        n = n.next;
        while (n != null) {
            if (n.key.equals(key)) {
                prv.next = n.next;
                return;
            }
            n = n.next;
            prv = prv.next;
        }
    }
}
