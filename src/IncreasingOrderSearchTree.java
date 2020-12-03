
public class IncreasingOrderSearchTree {

    private TreeNode result;

    public TreeNode increasingBST(TreeNode root) {
        this.result = new TreeNode(-1);
        TreeNode head = this.result;
        inOrderDfs(root);
        return head.right;
    }

    private void inOrderDfs(TreeNode root) {
        if (root != null) {
            inOrderDfs(root.left);

            this.result.right = new TreeNode(root.val);
            this.result = this.result.right;

            inOrderDfs(root.right);
        }
    }

    public static void main(String args[]) {
        IncreasingOrderSearchTree iost = new IncreasingOrderSearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        System.out.println(iost.increasingBST(root));
    }
}
