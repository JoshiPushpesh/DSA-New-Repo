class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class KGroupReversalLinkedList1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;
        ListNode end = head;

        while (true) {
            int count = 0;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }
            if (count < k) break;

            ListNode start = prevGroup.next;
            ListNode nextGroup = end;

            // Reverse k nodes
            ListNode prev = nextGroup;
            ListNode curr = start;

            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            prevGroup.next = prev;
            prevGroup = start;
        }

        return dummy.next;
    }

    // Helper: Print linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        KGroupReversalLinkedList1 obj = new KGroupReversalLinkedList1();
        System.out.println("Original List:");
        obj.printList(n1);

        ListNode newHead = obj.reverseKGroup(n1, 2);
        System.out.println("List after reversing in groups of 2:");
        obj.printList(newHead);
    }
}
