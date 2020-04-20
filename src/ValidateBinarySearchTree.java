
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int smallest, int largest) {
        if (root == null) {
            return true;
        }
        if (root.left != null && (root.left.val >= root.val || root.left.val <= smallest)) {
            return false;
        }
        if (root.right != null && (root.right.val <= root.val || root.right.val >= largest)) {
            return false;
        }
        boolean isValid;
        isValid = dfs(root.left, smallest, root.val);
        isValid = isValid && dfs(root.right, root.val, largest);
        return isValid;
    }

    public static void main(String args[]) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);
        System.out.println(vbst.isValidBST(root));
    }
}
