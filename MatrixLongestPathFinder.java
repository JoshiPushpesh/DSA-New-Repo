class MatrixLongestPathFinder {
    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m, n;
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];

        int max = 1; // at least the cell itself
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                matrix[newRow][newCol] > matrix[row][col]) {
                max = Math.max(max, 1 + dfs(matrix, newRow, newCol));
            }
        }
        memo[row][col] = max;
        return max;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        MatrixLongestPathFinder solver = new MatrixLongestPathFinder();
        int[][] matrix = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        System.out.println(solver.longestIncreasingPath(matrix)); // Output: 4
    }
}
