class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create copy nodes interleaved
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            copyCurr.next = copy;
            copyCurr = copy;
            curr = curr.next;
        }

        return dummy.next;
    }

    // Utility: Print list with random pointers
    public static void printList(Node head) {
        while (head != null) {
            int randomVal = (head.random != null) ? head.random.val : -1;
            System.out.println("Node(" + head.val + ") Random(" + randomVal + ")");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create a sample list: 1 -> 2 -> 3, with some randoms
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2; n2.next = n3;
        n1.random = n3; // 1 -> random to 3
        n2.random = n1; // 2 -> random to 1
        n3.random = n3; // 3 -> random to itself

        System.out.println("Original list:");
        printList(n1);

        Node copied = copyRandomList(n1);

        System.out.println("\nCopied list:");
        printList(copied);
    }
}
