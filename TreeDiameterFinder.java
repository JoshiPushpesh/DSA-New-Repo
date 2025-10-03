class TreeDiameterFinder {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        // Build sample tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeDiameterFinder solver = new TreeDiameterFinder();
        System.out.println(solver.diameterOfBinaryTree(root)); // Output: 3
    }
}

// TreeNode class (LeetCode-style)
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
