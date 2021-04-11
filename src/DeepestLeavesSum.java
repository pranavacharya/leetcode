
public class DeepestLeavesSum {

    private int maxDepth = 0;
    private int maxDepthSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return this.maxDepthSum;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        depth++;
        if (this.maxDepth < depth) {
            this.maxDepth = depth;
            this.maxDepthSum = 0;
            this.maxDepthSum += root.val;
        } else if (this.maxDepth == depth) {
            this.maxDepthSum += root.val;
        }

        dfs(root.left, depth);
        dfs(root.right, depth);

    }

    public static void main(String[] args) {
        DeepestLeavesSum dls = new DeepestLeavesSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(dls.deepestLeavesSum(root));
    }
}
