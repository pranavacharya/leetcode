
public class BinaryTreeMaximumPathSum {

    private int max;

    public int maxPathSum(TreeNode root) {
        this.max = root.val;
        if (root == null) {
            return this.max;
        }
        helper(root);
        return this.max;
    }

    private int helper(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = helper(root.left);
        }
        if (root.right != null) {
            right = helper(root.right);
        }
        this.max = Math.max(this.max, left + root.val);
        this.max = Math.max(this.max, right + root.val);
        this.max = Math.max(this.max, root.val);
        this.max = Math.max(this.max, left + right + root.val);
        return Math.max(0, Math.max(root.val, Math.max(left, right) + root.val));
    }

    public static void main(String args[]) {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(btmps.maxPathSum(root));
    }
}
