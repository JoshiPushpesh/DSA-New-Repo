import java.util.*;

public class WordSearchWithTrie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // stores complete word at terminal node
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w;
        }
        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private static void dfs(char[][] board, int r, int c,
                            TrieNode node, List<String> result) {

        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#'; // mark visited

        if (r > 0) dfs(board, r - 1, c, node, result);
        if (c > 0) dfs(board, r, c - 1, node, result);
        if (r < board.length - 1) dfs(board, r + 1, c, node, result);
        if (c < board[0].length - 1) dfs(board, r, c + 1, node, result);

        board[r][c] = ch; // backtrack
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        System.out.println("Words found: " + findWords(board, words));
    }
}
