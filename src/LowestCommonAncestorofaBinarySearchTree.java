
public class LowestCommonAncestorofaBinarySearchTree {

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private int[] helper(TreeNode root, TreeNode p, TreeNode q) {
        int[] ans = new int[]{0, 0};

        if (root.val == p.val) {
            ans[0] = 1;
        }

        if (root.val == q.val) {
            ans[1] = 1;
        }

        if (root.left != null) {
            int[] local = helper(root.left, p, q);
            ans[0] = Math.max(ans[0], local[0]);
            ans[1] = Math.max(ans[1], local[1]);
        }

        if (root.right != null) {
            int[] local = helper(root.right, p, q);
            ans[0] = Math.max(ans[0], local[0]);
            ans[1] = Math.max(ans[1], local[1]);
        }

        if (ans[0] == 1 && ans[1] == 1 && result == null) {
            this.result = root;
        }

        return ans;
    }

}
