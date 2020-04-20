
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer llimit, Integer ulimit) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val >= root.val) || (root.left != null && llimit != null && root.left.val <= llimit)) {
            return false;
        }
        if ((root.right != null && root.right.val <= root.val) || (root.right != null && ulimit != null && root.right.val >= ulimit)) {
            return false;
        }
        boolean isValid;
        isValid = dfs(root.left, llimit, root.val);
        isValid = isValid && dfs(root.right, root.val, ulimit);
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
