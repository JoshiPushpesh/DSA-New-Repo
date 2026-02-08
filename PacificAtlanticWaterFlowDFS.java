import java.util.*;

public class PacificAtlanticWaterFlowDFS {

    private static int rows, cols;
    private static int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row & left column
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
        }

        // Atlantic: bottom row & right column
        for (int c = 0; c < cols; c++) {
            dfs(rows - 1, c, atlantic, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, cols - 1, atlantic, heights);
        }

        // Collect cells reachable by both
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private static void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc]
                    && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        List<List<Integer>> ans = pacificAtlantic(heights);
        System.out.println("Cells flowing to both oceans:");
        for (List<Integer> cell : ans) {
            System.out.println(cell);
        }
    }
}
