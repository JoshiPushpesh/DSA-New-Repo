class DNode {
    int val;
    DNode prev, next, child;

    DNode(int val) {
        this.val = val;
    }
}

public class MultiLevelFlattener {

    public DNode flatten(DNode head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    // Helper function to recursively flatten
    private DNode flattenDFS(DNode node) {
        DNode curr = node;
        DNode last = null;

        while (curr != null) {
            DNode next = curr.next;

            // If child exists, recursively flatten
            if (curr.child != null) {
                DNode childTail = flattenDFS(curr.child);

                // Connect current node with child
                curr.next = curr.child;
                curr.child.prev = curr;

                // If next exists, connect child's tail with next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null; // remove child pointer
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }

    // Print flattened list
    public void printList(DNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MultiLevelFlattener obj = new MultiLevelFlattener();

        // Create nodes
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        DNode n4 = new DNode(4);
        DNode n5 = new DNode(5);
        DNode n6 = new DNode(6);
        DNode n7 = new DNode(7);
        DNode n8 = new DNode(8);
        DNode n9 = new DNode(9);

        // Main list
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        // Child lists
        n3.child = n6;
        n6.next = n7; n7.prev = n6;
        n7.child = n8;
        n8.next = n9; n9.prev = n8;

        System.out.println("Flattened List:");
        DNode flatHead = obj.flatten(n1);
        obj.printList(flatHead);
    }
}
