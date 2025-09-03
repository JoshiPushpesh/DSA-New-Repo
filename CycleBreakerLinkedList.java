class CNode {
    int val;
    CNode next;
    CNode(int val) { this.val = val; }
}

public class CycleBreakerLinkedList {

    public boolean detectAndRemoveCycle(CNode head) {
        if (head == null || head.next == null) return false;

        CNode slow = head, fast = head;

        // Detect cycle using Floyd’s Tortoise & Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeCycle(slow, head);
                return true;
            }
        }
        return false;
    }

    private void removeCycle(CNode meetingPoint, CNode head) {
        CNode ptr1 = head;
        CNode ptr2 = meetingPoint;

        // Move ptr1 and ptr2 one step at a time until they meet at cycle start
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Find the node before cycle start to break the cycle
        CNode prev = ptr2;
        while (prev.next != ptr1) {
            prev = prev.next;
        }
        prev.next = null; // Break the cycle
    }

    public void printList(CNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle: 1->2->3->4->5->3...
        CNode n1 = new CNode(1);
        CNode n2 = new CNode(2);
        CNode n3 = new CNode(3);
        CNode n4 = new CNode(4);
        CNode n5 = new CNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3; // Cycle here

        CycleBreakerLinkedList obj = new CycleBreakerLinkedList();
        boolean cycleFound = obj.detectAndRemoveCycle(n1);
        System.out.println("Cycle detected: " + cycleFound);

        System.out.println("List after removing cycle:");
        obj.printList(n1);
    }
}
