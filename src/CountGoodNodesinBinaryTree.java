
public class CountGoodNodesinBinaryTree {

    private int count;

    public CountGoodNodesinBinaryTree() {
        this.count = 0;
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return this.count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        } else {
            if (root.val >= max) {
                this.count++;
            }
            dfs(root.left, Math.max(max, root.val));
            dfs(root.right, Math.max(max, root.val));
        }
    }

    public static void main(String args[]) {
        CountGoodNodesinBinaryTree cgnibt = new CountGoodNodesinBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(cgnibt.goodNodes(root));
    }
}
