class MultiNode {
    int val;
    MultiNode prev, next, child;
    MultiNode(int val) {
        this.val = val;
    }
}

public class FlattenMultiLevelList {
    
    public MultiNode flatten(MultiNode head) {
        if (head == null) return head;
        MultiNode pseudoHead = new MultiNode(0);
        pseudoHead.next = head;
        head.prev = pseudoHead;

        flattenDFS(pseudoHead, head);

        // Detach dummy head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    private MultiNode flattenDFS(MultiNode prev, MultiNode curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        MultiNode next = curr.next;
        MultiNode tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, next);
    }

    // Test
    public static void main(String[] args) {
        // Create nodes
        MultiNode n1 = new MultiNode(1);
        MultiNode n2 = new MultiNode(2);
        MultiNode n3 = new MultiNode(3);
        MultiNode n4 = new MultiNode(4);
        MultiNode n5 = new MultiNode(5);
        MultiNode n6 = new MultiNode(6);
        MultiNode n7 = new MultiNode(7);
        MultiNode n8 = new MultiNode(8);
        MultiNode n9 = new MultiNode(9);
        MultiNode n10 = new MultiNode(10);
        MultiNode n11 = new MultiNode(11);
        MultiNode n12 = new MultiNode(12);

        // Setup next pointers
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

        FlattenMultiLevelList obj = new FlattenMultiLevelList();
        MultiNode head = obj.flatten(n1);

        // Print flattened list
        MultiNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
