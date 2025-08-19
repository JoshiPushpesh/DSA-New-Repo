class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListRandomPointer {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copied nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Copy random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate lists
        Node dummy = new Node(0);
        Node copyCurr = dummy, copyHead;
        curr = head;

        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }

        copyHead = dummy.next;
        return copyHead;
    }

    // Utility: Print list (val + random.val)
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.print("[" + curr.val + ", random=" + randomVal + "] -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main function
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Setting random pointers
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println("Original List:");
        printList(head);

        Node copied = copyRandomList(head);

        System.out.println("Copied List:");
        printList(copied);
    }
}
