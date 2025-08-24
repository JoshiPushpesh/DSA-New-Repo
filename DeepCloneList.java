class RNode {
    int val;
    RNode next, random;

    RNode(int val) {
        this.val = val;
    }
}

public class DeepCloneList {

    public RNode copyRandomList(RNode head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes
        RNode curr = head;
        while (curr != null) {
            RNode temp = new RNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        // Step 2: Set random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        curr = head;
        RNode cloneHead = head.next;
        RNode cloneCurr = cloneHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }

    // Print list with random pointers
    public void printList(RNode head) {
        while (head != null) {
            int randomVal = (head.random != null) ? head.random.val : -1;
            System.out.println("Node: " + head.val + ", Random: " + randomVal);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        DeepCloneList obj = new DeepCloneList();

        // Creating list: 1 -> 2 -> 3 -> 4
        RNode head = new RNode(1);
        head.next = new RNode(2);
        head.next.next = new RNode(3);
        head.next.next.next = new RNode(4);

        // Setting random pointers
        head.random = head.next.next;         // 1 -> 3
        head.next.random = head;              // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next;      // 4 -> 2

        System.out.println("Original list:");
        obj.printList(head);

        RNode clonedHead = obj.copyRandomList(head);

        System.out.println("\nCloned list:");
        obj.printList(clonedHead);
    }
}
