import java.util.Arrays;

public class KthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0; // smallest possible distance
        int right = nums[n - 1] - nums[0]; // max distance

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= maxDist) {
                j++;
            }
            count += j - i - 1;
        }

        return count;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;

        int result = smallestDistancePair(nums, k);
        System.out.println("K-th smallest pair distance: " + result);
    }
}
