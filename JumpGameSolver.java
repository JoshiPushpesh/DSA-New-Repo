class JumpGameSolver {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        JumpGameSolver solver = new JumpGameSolver();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solver.jump(nums)); // Output: 2
    }
}
