import java.util.*;

class IncreasingSubsequenceFinder {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        IncreasingSubsequenceFinder solver = new IncreasingSubsequenceFinder();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(solver.lengthOfLIS(nums)); // Output: 4
    }
}
