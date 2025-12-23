import java.util.*;

class LISOptimizerX {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            // binary search on tails[0..size)
            while (i < j) {
                int mid = (i + j) >>> 1;
                if (tails[mid] < x) i = mid + 1;
                else j = mid;
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        LISOptimizerX solver = new LISOptimizerX();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Length of LIS: " + solver.lengthOfLIS(nums)); // 4
    }
}
