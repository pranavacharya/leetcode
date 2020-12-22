
public class BalancedBinaryTree {

    private int maxDiff;

    public boolean isBalanced(TreeNode root) {
        this.maxDiff = 0;
        dfs(root);
        return this.maxDiff <= 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        this.maxDiff = Math.max(this.maxDiff, Math.abs(left - right));
        return 1 + Math.max(left, right);
    }

    public static void main(String args[]) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(bbt.isBalanced(root));
    }
}
