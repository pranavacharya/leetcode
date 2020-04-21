
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int sum) {
        if (root != null && root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
        }
    }

    public static void main(String args[]) {
        PathSum ps = new PathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(ps.hasPathSum(root, 2));
    }
}
