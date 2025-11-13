import java.util.*;

class PathSumExplorerX {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result) {
        if (node == null) return;

        current.add(node.val);
        sum -= node.val;

        // ✅ Found a root-to-leaf path
        if (sum == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(current));
        } else {
            findPaths(node.left, sum, current, result);
            findPaths(node.right, sum, current, result);
        }

        current.remove(current.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        PathSumExplorerX explorer = new PathSumExplorerX();

        // Construct the example tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = explorer.pathSum(root, targetSum);
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
