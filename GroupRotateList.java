class GNode {
    int val;
    GNode next;

    GNode(int val) {
        this.val = val;
    }
}

public class GroupRotateList {

    public GNode reverseKGroup(GNode head, int k) {
        if (head == null || k == 1) return head;

        GNode dummy = new GNode(0);
        dummy.next = head;
        GNode curr = dummy, nex = dummy, pre = dummy;

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

    // Print the list
    public void printList(GNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GroupRotateList obj = new GroupRotateList();

        // Creating linked list: 1->2->3->4->5->6->7->8
        GNode head = new GNode(1);
        head.next = new GNode(2);
        head.next.next = new GNode(3);
        head.next.next.next = new GNode(4);
        head.next.next.next.next = new GNode(5);
        head.next.next.next.next.next = new GNode(6);
        head.next.next.next.next.next.next = new GNode(7);
        head.next.next.next.next.next.next.next = new GNode(8);

        System.out.println("Original list:");
        obj.printList(head);

        int k = 3;
        GNode newHead = obj.reverseKGroup(head, k);

        System.out.println("List after reversing in groups of " + k + ":");
        obj.printList(newHead);
    }
}
