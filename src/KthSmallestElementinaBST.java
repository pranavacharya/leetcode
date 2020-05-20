
public class KthSmallestElementinaBST {

    private int count;
    private int ans;
    private boolean found;

    public KthSmallestElementinaBST() {
        this.count = 0;
        this.found = false;
        this.ans = -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inOrderTraversal(root);
        return this.ans;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root != null && !this.found) {
            inOrderTraversal(root.left);
            this.count--;
            if (this.count == 0) {
                this.ans = root.val;
                this.found = true;
            }
            inOrderTraversal(root.right);
        }
    }

}
