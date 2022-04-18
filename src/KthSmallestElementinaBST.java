
public class KthSmallestElementinaBST {

    int count;
    int k;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.count = 0;
        this.ans = root.val;

        inorder(root);

        return this.ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        this.count++;
        if (this.k == this.count) {
            ans = root.val;
        }
        inorder(root.right);
    }

    public static void main(String args[]) {
        KthSmallestElementinaBST kme = new KthSmallestElementinaBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kme.kthSmallest(root, 3));
        
    }

}
