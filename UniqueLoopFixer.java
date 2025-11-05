class UniqueLoopFixer {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node detectAndRemoveLoop(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd’s Cycle Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop found
                removeLoop(slow, head);
                return head;
            }
        }
        return head; // No loop
    }

    // Helper to remove loop
    private static void removeLoop(Node loopNode, Node head) {
        Node ptr1 = head;
        Node ptr2;

        while (true) {
            ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1)
                ptr2 = ptr2.next;

            if (ptr2.next == ptr1)
                break;

            ptr1 = ptr1.next;
        }

        ptr2.next = null; // Break the loop
    }

    // Utility to print list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop for testing
        head.next.next.next.next.next = head.next.next;

        head = detectAndRemoveLoop(head);

        System.out.println("Linked List after removing loop:");
        printList(head);
    }
}
