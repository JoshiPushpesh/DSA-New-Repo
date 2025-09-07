class RandomNode {
    int val;
    RandomNode next, random;
    RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCloneRandomList {

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        // Step 1: Clone nodes and insert them next to original nodes
        RandomNode curr = head;
        while (curr != null) {
            RandomNode newNode = new RandomNode(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers to the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        curr = head;
        RandomNode dummy = new RandomNode(0);
        RandomNode copy = dummy;

        while (curr != null) {
            RandomNode cloned = curr.next;
            curr.next = cloned.next;
            copy.next = cloned;
            copy = cloned;
            curr = curr.next;
        }

        return dummy.next;
    }

    // Helper: Print the list (val and random)
    public void printList(RandomNode head) {
        RandomNode curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node: " + curr.val + " | Random: " + randomVal);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create original list
        RandomNode n1 = new RandomNode(1);
        RandomNode n2 = new RandomNode(2);
        RandomNode n3 = new RandomNode(3);
        RandomNode n4 = new RandomNode(4);

        n1.next = n2; n2.next = n3; n3.next = n4;
        n1.random = n3; n2.random = n1; n3.random = n4; n4.random = n2;

        DeepCloneRandomList solution = new DeepCloneRandomList();
        System.out.println("Original List:");
        solution.printList(n1);

        RandomNode clonedHead = solution.copyRandomList(n1);
        System.out.println("Cloned List:");
        solution.printList(clonedHead);
    }
}
