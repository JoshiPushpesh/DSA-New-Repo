import java.util.*;

public class MinimumCostConnectSticks {

    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all sticks to the heap
        for (int stick : sticks) {
            minHeap.add(stick);
        }

        int cost = 0;

        // Keep combining until one stick remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int newStick = first + second;
            cost += newStick;

            minHeap.add(newStick);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] sticks = {2, 4, 3};

        int result = connectSticks(sticks);
        System.out.println("Minimum total cost to connect sticks: " + result);
    }
}
