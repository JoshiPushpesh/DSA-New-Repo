class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class KGroupLinkedListReversal {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, nex = dummy, pre = dummy;
        int count = 0;

        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dummy.next;
    }

    // Helper to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 1->2->3->4->5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        KGroupLinkedListReversal obj = new KGroupLinkedListReversal();
        System.out.println("Original List:");
        obj.printList(n1);

        ListNode newHead = obj.reverseKGroup(n1, 3);
        System.out.println("List after reversing in groups of 3:");
        obj.printList(newHead);
    }
}
