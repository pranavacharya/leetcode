
public class InsufficientNodesinRoottoLeafPaths {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        dfs(root, limit, 0);
        if (root.left == null && root.right == null && root.val < limit) {
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode root, int limit, int sum) {
        if (root != null && root.left == null && root.right == null) {
            return limit <= (sum + root.val);
        } else {
            if (root.left != null && !dfs(root.left, limit, sum + root.val)) {
                root.left = null;
            }
            if (root.right != null && !dfs(root.right, limit, sum + root.val)) {
                root.right = null;
            }
            if (root.left == null && root.right == null) {
                return false;
            } else {
                return true;
            }
        }
    }
}
