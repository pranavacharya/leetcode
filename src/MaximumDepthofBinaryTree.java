
public class MaximumDepthofBinaryTree {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return this.depth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            this.depth = Math.max(this.depth, depth);
        } else {
            if (root.left != null) {
                dfs(root.left, depth + 1);
            }
            if (root.right != null) {
                dfs(root.right, depth + 1);
            }
        }
    }

    public static void main(String args[]) {
        MaximumDepthofBinaryTree mdbt = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(mdbt.maxDepth(root));
    }
}
