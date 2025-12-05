import java.util.*;

class RottingOrangesSolverX {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: count fresh oranges and add rotten ones to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        // Edge case: no fresh oranges
        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS process
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOrangesSolverX solver = new RottingOrangesSolverX();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println("Minutes to rot all oranges: " + solver.orangesRotting(grid));
    }
}
