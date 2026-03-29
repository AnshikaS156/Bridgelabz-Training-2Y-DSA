import java.util.*;

class MyHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private int capacity = 10;
    private LinkedList<Node<K, V>>[] buckets;

    public MyHashMap() {
       
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);

        buckets[index].removeIf(node -> node.key.equals(key));
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        System.out.println(map.get("A")); // 1
        map.remove("A");
        System.out.println(map.get("A")); // null
    }
}