class CircularHouseRobberX2 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Rob from house 0 to n-2
        int case1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob from house 1 to n-1
        int case2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        CircularHouseRobberX2 robber = new CircularHouseRobberX2();

        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("Max loot (case 1): " + robber.rob(nums1)); // 3
        System.out.println("Max loot (case 2): " + robber.rob(nums2)); // 4
    }
}
