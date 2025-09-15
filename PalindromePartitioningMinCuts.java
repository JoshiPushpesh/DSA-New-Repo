class PalindromePartitioningMinCuts {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        // Precompute palindrome substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && 
                   (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // whole substring is palindrome
            } else {
                dp[i] = i; // max cuts = i
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    // 🔹 Demo main function
    public static void main(String[] args) {
        PalindromePartitioningMinCuts solver = new PalindromePartitioningMinCuts();
        System.out.println(solver.minCut("aab")); // Output: 1
        System.out.println(solver.minCut("a"));   // Output: 0
        System.out.println(solver.minCut("ab"));  // Output: 1
    }
}
