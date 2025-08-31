import java.util.*;

class RandomNode {
    int val;
    RandomNode next, random;

    RandomNode(int val) {
        this.val = val;
    }
}

public class DeepCopyRandomList {

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;

        // First pass: create all nodes
        while (curr != null) {
            map.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // Test
    public static void main(String[] args) {
        RandomNode n1 = new RandomNode(7);
        RandomNode n2 = new RandomNode(13);
        RandomNode n3 = new RandomNode(11);
        RandomNode n4 = new RandomNode(10);
        RandomNode n5 = new RandomNode(1);

        // Setup next
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        // Setup random
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        DeepCopyRandomList obj = new DeepCopyRandomList();
        RandomNode copyHead = obj.copyRandomList(n1);

        // Print original and copied list
        System.out.println("Original and copied list values:");
        RandomNode orig = n1, copy = copyHead;
        while (orig != null) {
            System.out.println("Original: " + orig.val +
                    ", Random: " + (orig.random != null ? orig.random.val : "null") +
                    " | Copy: " + copy.val +
                    ", Random: " + (copy.random != null ? copy.random.val : "null"));
            orig = orig.next;
            copy = copy.next;
        }
    }
}
