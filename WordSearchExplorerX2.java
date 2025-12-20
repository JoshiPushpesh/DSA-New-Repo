class WordSearchExplorerX2 {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
            board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp; // backtrack
        return found;
    }

    public static void main(String[] args) {
        WordSearchExplorerX2 solver = new WordSearchExplorerX2();

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println(solver.exist(board, "ABCCED")); // true
        System.out.println(solver.exist(board, "SEE"));    // true
        System.out.println(solver.exist(board, "ABCB"));   // false
    }
}
