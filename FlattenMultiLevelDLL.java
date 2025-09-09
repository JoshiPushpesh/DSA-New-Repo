class Node {
    int val;
    Node prev, next, child;
    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

public class FlattenMultiLevelDLL {

    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = new Node(0);
        Node prev = dummy;
        flattenDFS(prev, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        Node next = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, next);
    }

    // Helper: Print doubly linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Building a multi-level doubly linked list
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        n3.child = n7;
        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n8.child = n11;
        n11.next = n12; n12.prev = n11;

        FlattenMultiLevelDLL obj = new FlattenMultiLevelDLL();
        System.out.println("Flattening the multilevel doubly linked list:");
        Node flatHead = obj.flatten(n1);
        obj.printList(flatHead);
    }
}
