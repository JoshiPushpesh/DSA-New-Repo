class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class CycleFinderPro {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move one step
            fast = fast.next.next;     // move two steps

            if (slow == fast) return true;  // cycle detected
        }
        return false; // reached end, no cycle
    }

    public static void main(String[] args) {
        // Create linked list: 3 -> 2 -> 0 -> -4 -> (cycle to node 2)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // create cycle
        head.next.next.next.next = head.next;

        CycleFinderPro finder = new CycleFinderPro();
        System.out.println("Cycle present: " + finder.hasCycle(head));  // true
    }
}
