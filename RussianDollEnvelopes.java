import java.util.*;

public class RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort by width ASC, height DESC
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // Step 2: Find LIS on heights
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int idx = Arrays.binarySearch(dp, 0, len, h);
            if (idx < 0) idx = -(idx + 1); // insertion point
            dp[idx] = h;
            if (idx == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = {
            {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };

        int result = maxEnvelopes(envelopes);
        System.out.println("Max number of envelopes: " + result);
    }
}
