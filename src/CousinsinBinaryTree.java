
public class CousinsinBinaryTree {

    private Integer parent;
    private int depth;

    public CousinsinBinaryTree() {
        this.parent = null;
        this.depth = 0;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int parentx, parenty;
        int depthx, depthy;
        findDepthAndParent(root, x, null, 0);
        parentx = this.parent;
        depthx = this.depth;
        findDepthAndParent(root, y, null, 0);
        parenty = this.parent;
        depthy = this.depth;
        return ((depthx == depthy) && (parentx != parenty));
    }

    public void findDepthAndParent(TreeNode root, int key, Integer parent, int depth) {
        if (root.val == key) {
            this.depth = depth;
            if (parent == null) {
                this.parent = 0;
            } else {
                this.parent = parent;
            }

        } else {
            if (root.left != null) {
                findDepthAndParent(root.left, key, root.val, depth + 1);
            }
            if (root.right != null) {
                findDepthAndParent(root.right, key, root.val, depth + 1);
            }
        }
    }

    public static void main(String args[]) {
        CousinsinBinaryTree cibt = new CousinsinBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(cibt.isCousins(root, 2, 3));
    }
}
