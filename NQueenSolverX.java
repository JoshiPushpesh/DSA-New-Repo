import java.util.*;

class NQueenSolverX {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, solutions, n);
        return solutions;
    }

    private void backtrack(int row, char[][] board, List<List<String>> solutions, int n) {
        if (row == n) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, solutions, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // Check diagonal (top-left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // Check diagonal (top-right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        NQueenSolverX solver = new NQueenSolverX();
        List<List<String>> solutions = solver.solveNQueens(4);
        System.out.println("Solutions for 4-Queens:");
        for (List<String> sol : solutions) {
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
    }
}
