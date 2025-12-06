class MatrixPathExplorerX {

    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int rows, cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int longest = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, memo));
            }
        }

        return longest;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1; // current cell
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            if (r >= 0 && c >= 0 && r < rows && c < cols && matrix[r][c] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, r, c, memo));
            }
        }

        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        MatrixPathExplorerX solver = new MatrixPathExplorerX();
        int[][] matrix = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        System.out.println("Longest Increasing Path Length: " + solver.longestIncreasingPath(matrix));
    }
}
