import java.util.*;

class ZigzagTreeTraverserX {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight)
                    currentLevel.add(node.val);
                else
                    currentLevel.add(0, node.val); // add in reverse order

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // flip direction
        }

        return result;
    }

    public static void main(String[] args) {
        ZigzagTreeTraverserX traverser = new ZigzagTreeTraverserX();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Zigzag Level Order Traversal: " + traverser.zigzagLevelOrder(root));
    }
}
