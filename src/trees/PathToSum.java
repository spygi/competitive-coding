package trees;

/**
 * Leetcode 112 or more difficult CtCI 4.9
 */
public class PathToSum {
    /**
     * The path must be root to leaf!
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (sum - root.val == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
