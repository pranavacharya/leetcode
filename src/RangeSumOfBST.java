
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = search(root, 0, L, R);
        return sum;
    }

    public int search(TreeNode root, int sum, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val <= R && root.val >= L) {
            sum += root.val;
        }
        if (root.left != null) {
            sum = search(root.left, sum, L, R);
        }
        if (root.right != null) {
            sum = search(root.right, sum, L, R);
        }
        return sum;
    }

    public static void main(String args[]) {
        RangeSumOfBST rsob = new RangeSumOfBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rsob.rangeSumBST(root, 7, 15));
    }

}
