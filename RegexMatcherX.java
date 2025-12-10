class RegexMatcherX {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty string vs empty pattern

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Two options for '*':
                    // 1️⃣ Treat '*' as 0 occurrence → skip previous pattern (j - 2)
                    // 2️⃣ If previous pattern matches current char → use '*' again
                    dp[i][j] = dp[i][j - 2] || 
                               ((p.charAt(j - 2) == sc || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegexMatcherX matcher = new RegexMatcherX();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println("Does string match pattern? " + matcher.isMatch(s, p));
    }
}
