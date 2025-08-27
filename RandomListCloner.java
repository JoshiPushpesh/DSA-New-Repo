import java.util.*;

class RNode {
    int val;
    RNode next, random;

    RNode(int val) {
        this.val = val;
    }
}

public class RandomListCloner {

    public RNode copyRandomList(RNode head) {
        if (head == null) return null;

        Map<RNode, RNode> map = new HashMap<>();

        // Step 1: Create a mapping from original to copied node
        RNode curr = head;
        while (curr != null) {
            map.put(curr, new RNode(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        // Step 3: Return copied head
        return map.get(head);
    }

    // Print list with random pointers
    public void printList(RNode head) {
        RNode curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node " + curr.val + " | Random -> " + randomVal);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        RandomListCloner obj = new RandomListCloner();

        // Create original list
        RNode n1 = new RNode(7);
        RNode n2 = new RNode(13);
        RNode n3 = new RNode(11);
        RNode n4 = new RNode(10);
        RNode n5 = new RNode(1);

        // Next pointers
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Random pointers
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        System.out.println("Original List:");
        obj.printList(n1);

        System.out.println("\nCloned List:");
        RNode clonedHead = obj.copyRandomList(n1);
        obj.printList(clonedHead);
    }
}
