
public class BinaryTreeMaximumPathSum {

    private int max;

    public BinaryTreeMaximumPathSum() {
        this.max = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));
            this.max = Math.max(this.max, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
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
