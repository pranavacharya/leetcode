
public class MaximumDifferenceBetweenNodeandAncestor {

    private int maxDiff;

    public int maxAncestorDiff(TreeNode root) {
        this.maxDiff = 0;
        if (root == null) {
            return this.maxDiff;
        }
        dfs(root, root.val, root.val);
        return this.maxDiff;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        this.maxDiff = Math.max(this.maxDiff,
                Math.max(Math.abs(root.val - max), Math.abs(root.val - min)));
        dfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
        dfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
    }

    public static void main(String args[]) {
        MaximumDifferenceBetweenNodeandAncestor mdbna = new MaximumDifferenceBetweenNodeandAncestor();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(mdbna.maxAncestorDiff(root));
    }
}
