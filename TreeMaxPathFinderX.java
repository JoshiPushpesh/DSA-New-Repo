class TreeMaxPathFinderX {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Ignore negative contributions
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Update max sum if passing through this node
        maxSum = Math.max(maxSum, left + right + node.val);

        // Return max single-side path for recursion
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeMaxPathFinderX finder = new TreeMaxPathFinderX();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum: " + finder.maxPathSum(root));
    }
}
