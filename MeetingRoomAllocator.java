import java.util.*;

class MeetingRoomAllocator {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first meeting end time
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If earliest room is free, remove it
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            // Assign current meeting to a room
            minHeap.add(intervals[i][1]);
        }

        // Heap size = number of rooms needed
        return minHeap.size();
    }

    // 🔹 Demo
    public static void main(String[] args) {
        MeetingRoomAllocator solver = new MeetingRoomAllocator();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(solver.minMeetingRooms(intervals)); // Output: 2
    }
}
