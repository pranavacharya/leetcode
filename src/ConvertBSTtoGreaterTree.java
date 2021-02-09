
public class ConvertBSTtoGreaterTree {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.sum = 0;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }
        this.sum += root.val;
        root.val = this.sum;
        if (root.left != null) {
            helper(root.left);
        }
    }

    public static void main(String args[]) {
        ConvertBSTtoGreaterTree cbgt = new ConvertBSTtoGreaterTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(cbgt.convertBST(root));
    }
}
