import java.util.PriorityQueue;

class KNode {
    int val;
    KNode next;
    KNode(int val) { this.val = val; }
}

public class MergeManyLists {

    public KNode mergeKLists(KNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<KNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list
        for (KNode node : lists) {
            if (node != null) pq.add(node);
        }

        KNode dummy = new KNode(0);
        KNode tail = dummy;

        while (!pq.isEmpty()) {
            KNode min = pq.poll();
            tail.next = min;
            tail = tail.next;

            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }

    // Utility function to print a list
    public void printList(KNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeManyLists obj = new MergeManyLists();

        // Creating lists
        KNode l1 = new KNode(1);
        l1.next = new KNode(4);
        l1.next.next = new KNode(5);

        KNode l2 = new KNode(1);
        l2.next = new KNode(3);
        l2.next.next = new KNode(4);

        KNode l3 = new KNode(2);
        l3.next = new KNode(6);

        KNode[] lists = {l1, l2, l3};

        System.out.println("Merged List:");
        KNode merged = obj.mergeKLists(lists);
        obj.printList(merged);
    }
}
