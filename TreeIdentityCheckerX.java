class TreeIdentityCheckerX {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ✅ Check if two trees are identical
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeIdentityCheckerX checker = new TreeIdentityCheckerX();

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        System.out.println("Trees identical? " + checker.isSameTree(a, b));
    }
}
