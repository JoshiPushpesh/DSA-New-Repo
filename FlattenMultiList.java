class DLNode {
    int val;
    DLNode prev;
    DLNode next;
    DLNode child;

    DLNode(int val) {
        this.val = val;
    }
}

public class FlattenMultiList {

    public DLNode flatten(DLNode head) {
        if (head == null) return null;

        DLNode dummy = new DLNode(0);
        dummy.next = head;
        head.prev = dummy;

        flattenDFS(dummy, head);

        // detach dummy
        dummy.next.prev = null;
        return dummy.next;
    }

    private DLNode flattenDFS(DLNode prev, DLNode curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        DLNode tempNext = curr.next; // store next
        DLNode tail = flattenDFS(curr, curr.child); // flatten child
        curr.child = null; // remove child pointer

        return flattenDFS(tail, tempNext); // flatten next
    }

    // Print the flattened list
    public void printList(DLNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FlattenMultiList obj = new FlattenMultiList();

        // Creating the multilevel doubly linked list from example
        DLNode n1 = new DLNode(1);
        DLNode n2 = new DLNode(2);
        DLNode n3 = new DLNode(3);
        DLNode n4 = new DLNode(4);
        DLNode n5 = new DLNode(5);
        DLNode n6 = new DLNode(6);
        DLNode n7 = new DLNode(7);
        DLNode n8 = new DLNode(8);
        DLNode n9 = new DLNode(9);
        DLNode n10 = new DLNode(10);
        DLNode n11 = new DLNode(11);
        DLNode n12 = new DLNode(12);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        n3.child = n7;
        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;

        n8.child = n11;
        n11.next = n12; n12.prev = n11;

        DLNode flattened = obj.flatten(n1);

        System.out.println("Flattened list:");
        obj.printList(flattened);
    }
}
