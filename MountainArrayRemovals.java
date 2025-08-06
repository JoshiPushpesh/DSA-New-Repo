import java.util.Arrays;

public class MountainArrayRemovals {

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Calculate LIS from left to right
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Calculate LDS from right to left
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int maxMountainLen = 0;

        // A valid peak must have lis[i] > 1 and lds[i] > 1
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountainLen = Math.max(maxMountainLen, lis[i] + lds[i] - 1);
            }
        }

        return n - maxMountainLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};

        int result = minimumMountainRemovals(nums);
        System.out.println("Minimum removals to make mountain array: " + result);
    }
}
