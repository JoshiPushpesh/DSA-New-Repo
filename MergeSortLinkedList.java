class MNode {
    int val;
    MNode next;
    MNode(int val) { this.val = val; }
}

public class MergeSortLinkedList {

    // Main function to sort the linked list
    public MNode sortList(MNode head) {
        if (head == null || head.next == null) return head;

        // Find the middle of the list
        MNode mid = getMid(head);
        MNode right = mid.next;
        mid.next = null;

        MNode leftSorted = sortList(head);
        MNode rightSorted = sortList(right);

        return merge(leftSorted, rightSorted);
    }

    // Function to find the middle node
    private MNode getMid(MNode head) {
        MNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted lists
    private MNode merge(MNode l1, MNode l2) {
        MNode dummy = new MNode(0);
        MNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Helper to print list
    public void printList(MNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Test case
    public static void main(String[] args) {
        MNode n1 = new MNode(4);
        MNode n2 = new MNode(2);
        MNode n3 = new MNode(1);
        MNode n4 = new MNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        MergeSortLinkedList obj = new MergeSortLinkedList();
        System.out.println("Original List:");
        obj.printList(n1);

        MNode sorted = obj.sortList(n1);
        System.out.println("Sorted List:");
        obj.printList(sorted);
    }
}
