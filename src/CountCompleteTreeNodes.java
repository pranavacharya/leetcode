
public class CountCompleteTreeNodes {

    private int count = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return this.count;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        } else {
            this.count++;
            dfs(root.left);
            dfs(root.right);
        }
    }
}
