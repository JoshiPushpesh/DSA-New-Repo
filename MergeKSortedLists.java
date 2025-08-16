import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of each list to priority queue
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Extract min and add next node
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            tail.next = min;
            tail = tail.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }

    // Utility: create linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility: print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = createList(new int[]{1,4,5});
        ListNode l2 = createList(new int[]{1,3,4});
        ListNode l3 = createList(new int[]{2,6});

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);

        System.out.print("Merged list: ");
        printList(result);
    }
}
