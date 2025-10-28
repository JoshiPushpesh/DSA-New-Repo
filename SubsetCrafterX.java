import java.util.*;

class SubsetCrafterX {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(current));

        // Explore choices
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // include element
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        SubsetCrafterX scx = new SubsetCrafterX();
        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = scx.subsets(nums);

        System.out.println("All possible subsets:");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
