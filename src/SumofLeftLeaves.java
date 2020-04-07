
public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        if (root.left != null) {
            sum = dfs(root.left, sum);
        }
        if (root.right != null) {
            sum = dfs(root.right, sum);
        }
        return sum;
    }

    public static void main(String args[]) {
        SumofLeftLeaves soll = new SumofLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(soll.sumOfLeftLeaves(root));
    }
}
