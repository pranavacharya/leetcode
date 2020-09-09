
public class SumofRootToLeafBinaryNumbers {

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root != null) {
            dfs(root, "");
        }
        return this.sum;
    }

    private void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            path = path.concat("" + root.val);
            this.sum += Integer.parseInt(path, 2);
            return;
        }
        path = path.concat("" + root.val);
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
    }

    public static void main(String args[]) {
        SumofRootToLeafBinaryNumbers srlbn = new SumofRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(srlbn.sumRootToLeaf(root));
    }
}
