import java.util.*;

class SkipListNode {
    int val;
    SkipListNode[] forward;
    SkipListNode(int val, int level) {
        this.val = val;
        this.forward = new SkipListNode[level + 1];
    }
}

public class SkipListLinkedStructure {
    private static final int MAX_LEVEL = 4;
    private static final double P = 0.5;

    private final SkipListNode head;
    private int level;

    public SkipListLinkedStructure() {
        this.head = new SkipListNode(-1, MAX_LEVEL);
        this.level = 0;
    }

    private int randomLevel() {
        int lvl = 0;
        while (Math.random() < P && lvl < MAX_LEVEL) lvl++;
        return lvl;
    }

    public boolean search(int target) {
        SkipListNode curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode curr = head;

        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipListNode newNode = new SkipListNode(num, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode curr = head;

        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];
        if (curr == null || curr.val != num) return false;

        for (int i = 0; i <= level; i++) {
            if (update[i].forward[i] != curr) break;
            update[i].forward[i] = curr.forward[i];
        }

        while (level > 0 && head.forward[level] == null) level--;
        return true;
    }

    // Debug function
    public void printSkipList() {
        for (int i = level; i >= 0; i--) {
            System.out.print("Level " + i + ": ");
            SkipListNode node = head.forward[i];
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipListLinkedStructure skipList = new SkipListLinkedStructure();
        skipList.add(1);
        skipList.add(3);
        skipList.add(5);
        skipList.add(7);
        skipList.add(9);

        System.out.println("Skip List after inserts:");
        skipList.printSkipList();

        System.out.println("Search 3: " + skipList.search(3)); // true
        System.out.println("Search 4: " + skipList.search(4)); // false

        System.out.println("Erase 5: " + skipList.erase(5)); // true
        System.out.println("Erase 5 again: " + skipList.erase(5)); // false

        System.out.println("Skip List after deletions:");
        skipList.printSkipList();
    }
}
