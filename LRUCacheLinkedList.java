import java.util.*;

class DNode {
    int key, value;
    DNode prev, next;
    DNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheLinkedList {
    private final int capacity;
    private final Map<Integer, DNode> map;
    private final DNode head, tail;

    public LRUCacheLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DNode(0, 0);
        this.tail = new DNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                DNode lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            DNode newNode = new DNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(DNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    public static void main(String[] args) {
        LRUCacheLinkedList cache = new LRUCacheLinkedList(2);

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
