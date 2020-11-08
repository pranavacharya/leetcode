
public class BinaryTreeTilt {

    private int tilt;

    public int findTilt(TreeNode root) {
        this.tilt = 0;
        dfs(root);
        return this.tilt;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = dfs(root.left);
        int rightsum = dfs(root.right);
        this.tilt += Math.abs(leftsum - rightsum);
        return leftsum + rightsum + root.val;
    }

    public static void main(String args[]) {
        BinaryTreeTilt btt = new BinaryTreeTilt();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(btt.findTilt(root));
    }
}
