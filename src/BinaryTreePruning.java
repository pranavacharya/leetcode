
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        boolean status = helper(root);
        if (!status) {
            return null;
        }
        return root;
    }

    private boolean helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean status = false;

        if (root.left != null) {
            status = helper(root.left);
            if (!status) {
                root.left = null;
            }
        }

        if (root.right != null) {
            boolean right = helper(root.right);
            if (!right) {
                root.right = null;
            }
            status = status || right;
        }

        return root.val == 1 && status;
    }

    public static void main(String args[]) {
        BinaryTreePruning btp = new BinaryTreePruning();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(btp.pruneTree(root));
    }
}
