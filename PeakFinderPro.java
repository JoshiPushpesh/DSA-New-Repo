class PeakFinderPro {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in left part
                right = mid;
            } else {
                // Peak is in right part
                left = mid + 1;
            }
        }

        return left; // left == right is the peak index
    }

    public static void main(String[] args) {
        PeakFinderPro finder = new PeakFinderPro();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element found at index: " + finder.findPeakElement(nums));
    }
}
