import java.util.*;

public class MergeKSortedArrays {

    static class Node implements Comparable<Node> {
        int value;
        int row;
        int col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    public static List<Integer> mergeKSortedArrays(int[][] arr) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        int k = arr.length;

        // Insert the first element of every array
        for (int i = 0; i < k; i++) {
            if (arr[i].length > 0) {
                minHeap.add(new Node(arr[i][0], i, 0));
            }
        }

        // Merge all arrays
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            result.add(current.value);

            int nextCol = current.col + 1;
            if (nextCol < arr[current.row].length) {
                minHeap.add(new Node(arr[current.row][nextCol], current.row, nextCol));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 5, 9, 10},
            {2, 6, 8, 15},
            {3, 7, 11, 13}
        };

        List<Integer> merged = mergeKSortedArrays(arr);
        System.out.println("Merged Array: " + merged);
    }
}
