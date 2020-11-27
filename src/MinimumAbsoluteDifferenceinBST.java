
public class MinimumAbsoluteDifferenceinBST {

    private int min = Integer.MAX_VALUE;
    private Integer last = null;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return this.min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (last != null) {
            this.min = Math.min(this.min, root.val - last);
        }
        this.last = root.val;
        dfs(root.right);
    }

    public static void main(String args[]) {
        MinimumAbsoluteDifferenceinBST madib = new MinimumAbsoluteDifferenceinBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        System.out.println(madib.getMinimumDifference(root));
    }
}
