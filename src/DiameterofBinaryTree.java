
public class DiameterofBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return this.max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        this.max = Math.max(this.max, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String args[]) {
        DiameterofBinaryTree dobt = new DiameterofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(dobt.diameterOfBinaryTree(root));
    }
}
