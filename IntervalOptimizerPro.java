import java.util.*;

class IntervalOptimizerPro {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++; // overlap found, remove this one
            } else {
                prevEnd = intervals[i][1]; // update end if no overlap
            }
        }

        return count;
    }

    public static void main(String[] args) {
        IntervalOptimizerPro optimizer = new IntervalOptimizerPro();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("Intervals to remove: " + optimizer.eraseOverlapIntervals(intervals));
    }
}
    