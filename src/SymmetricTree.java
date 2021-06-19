
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        boolean status1 = false;
        boolean status2 = false;
        status1 = helper(left.left, right.right);
        status2 = helper(left.right, right.left);
        return status1 && status2;
    }

    public static void main(String args[]) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(st.isSymmetric(root));
    }
}
