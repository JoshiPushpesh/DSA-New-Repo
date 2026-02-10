public class DecodeWaysWithWildcard {

    private static final int MOD = 1_000_000_007;

    public static int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        dp[0] = 1;

        // First character
        if (s.charAt(0) == '*') dp[1] = 9;
        else if (s.charAt(0) != '0') dp[1] = 1;
        else dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // 1️⃣ Single character
            if (curr == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (curr != '0') {
                dp[i] += dp[i - 1];
            }

            // 2️⃣ Two characters
            if (prev == '*') {
                if (curr == '*') {
                    dp[i] += 15 * dp[i - 2]; // 11–19 & 21–26
                } else if (curr <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (prev == '1') {
                if (curr == '*') {
                    dp[i] += 9 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (prev == '2') {
                if (curr == '*') {
                    dp[i] += 6 * dp[i - 2];
                } else if (curr <= '6') {
                    dp[i] += dp[i - 2];
                }
            }

            dp[i] %= MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("*"));     // 9
        System.out.println(numDecodings("1*"));    // 18
        System.out.println(numDecodings("**"));    // 96
        System.out.println(numDecodings("2*3"));   // valid test
    }
}
