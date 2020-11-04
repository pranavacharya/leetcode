
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root.val != val) {
            return false;
        }
        boolean status = true;
        if (root.left != null) {
            status = status && dfs(root.left, val);
        }
        if (status && root.right != null) {
            status = dfs(root.right, val);
        }
        return status;
    }

    public static void main(String args[]) {
        UnivaluedBinaryTree ubt = new UnivaluedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        System.out.println(ubt.isUnivalTree(root));
    }
}
