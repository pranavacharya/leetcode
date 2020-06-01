
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
        } else if (root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
        } else {
            return;
        }
        if (root.left != null) {
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }

    public static void main(String args[]) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        ibt.invertTree(root);
    }
}
