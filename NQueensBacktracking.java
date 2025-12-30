import java.util.*;

public class NQueensBacktracking {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row - col + n
        boolean[] diag2 = new boolean[2 * n]; // row + col

        backtrack(0, n, board, results, cols, diag1, diag2);
        return results;
    }

    private static void backtrack(int row, int n, char[][] board,
                                  List<List<String>> results,
                                  boolean[] cols, boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            results.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board, results, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Total solutions: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
