import java.util.*;

class BalloonBurstSolverX {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastEnd = points[0][1];

        for (int[] balloon : points) {
            // If current balloon starts after last arrow position, we need a new arrow
            if (balloon[0] > lastEnd) {
                arrows++;
                lastEnd = balloon[1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        BalloonBurstSolverX solver = new BalloonBurstSolverX();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Minimum arrows needed: " + solver.findMinArrowShots(points));
    }
}
