
public class MinimumDistanceBetweenBSTNodes {

    private int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return this.min;
    }

    private void helper(TreeNode root) {
        if (root.left != null) {
            this.min = Math.min(this.min, root.val - rightMost(root.left));
            helper(root.left);
        }

        if (root.right != null) {
            this.min = Math.min(this.min, leftMost(root.right) - root.val);
            helper(root.right);
        }
    }

    private int leftMost(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int rightMost(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public static void main(String args[]) {
        MinimumDistanceBetweenBSTNodes mdbbn = new MinimumDistanceBetweenBSTNodes();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(mdbbn.minDiffInBST(root));
    }
}
