
public class MinimumDepthofBinaryTree {

    private int length;

    public int minDepth(TreeNode root) {
        this.length = Integer.MAX_VALUE;
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return this.length;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            this.length = Math.min(length, depth);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }

    public static void main(String args[]) {
        MinimumDepthofBinaryTree mdobt = new MinimumDepthofBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(mdobt.minDepth(root));
    }
}
