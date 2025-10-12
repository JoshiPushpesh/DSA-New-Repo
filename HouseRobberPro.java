class HouseRobberPro {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int current = prev1;

        for (int i = 2; i < nums.length; i++) {
            current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        HouseRobberPro robber = new HouseRobberPro();
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Maximum money robbed: " + robber.rob(houses));
    }
}
