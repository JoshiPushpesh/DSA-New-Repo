import java.util.*;

class DNode {
    int key, value;
    DNode prev, next;
    DNode(int k, int v) {
        key = k;
        value = v;
    }
}

public class LRUCacheLinked {
    private int capacity;
    private Map<Integer, DNode> map;
    private DNode head, tail;

    public LRUCacheLinked(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
        // Dummy head and tail
        head = new DNode(0, 0);
        tail = new DNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DNode node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev); // Remove LRU
        }
        insert(new DNode(key, value));
    }

    private void remove(DNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(DNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Main to test
    public static void main(String[] args) {
        LRUCacheLinked cache = new LRUCacheLinked(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
