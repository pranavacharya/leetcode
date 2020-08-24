
public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            sum += dfs(root);
        }
        return sum;
    }

    public int dfs(TreeNode root) {
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else if (root.left != null) {
            sum += dfs(root.left);
        }
        if (root.right != null) {
            sum += dfs(root.right);
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
