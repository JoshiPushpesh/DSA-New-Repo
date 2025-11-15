import java.util.*;

class ComboSumGeneratorX {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); // reuse same element
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        ComboSumGeneratorX generator = new ComboSumGeneratorX();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = generator.combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
