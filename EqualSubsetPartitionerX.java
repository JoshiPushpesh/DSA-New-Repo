import java.util.*;

class EqualSubsetPartitionerX {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // If total sum is odd, we can’t split equally
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 0/1 Knapsack logic
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        EqualSubsetPartitionerX partitioner = new EqualSubsetPartitionerX();
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Can partition [1,5,11,5]: " + partitioner.canPartition(nums1)); // true
        System.out.println("Can partition [1,2,3,5]: " + partitioner.canPartition(nums2)); // false
    }
}
