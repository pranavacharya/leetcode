
public class SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (helper(root, subRoot)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if ((root != null && subRoot == null) || (root == null && subRoot != null)) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        SubtreeofAnotherTree stat = new SubtreeofAnotherTree();
        TreeNode first = new TreeNode(3);
        first.left = new TreeNode(4);
        first.left.left = new TreeNode(1);
        first.right = new TreeNode(5);
        first.right.left = new TreeNode(2);
        TreeNode second = new TreeNode(3);
        second.left = new TreeNode(1);
        second.right = new TreeNode(2);
        System.out.println(stat.isSubtree(first, second));
    }
}
