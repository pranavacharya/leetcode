
public class CountCompleteTreeNodes {

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + height(root.left);
        }
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0) {
            return 0;
        }
        int rightHeight = height(root.right);
        if (rightHeight == h - 1) {
            return (1 << h) + countNodes(root.right);
        } else {
            return (1 << (h - 1)) + countNodes(root.left);
        }
    }

}
