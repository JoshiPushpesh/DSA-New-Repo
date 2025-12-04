import java.util.*;

class WordBreakSolverX2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string can be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreakSolverX2 solver = new WordBreakSolverX2();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");

        System.out.println("Can be segmented? " + solver.wordBreak(s, wordDict)); // true
    }
}
