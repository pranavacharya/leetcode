
public class MinimumDistanceBetweenBSTNodes {

    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }

    public static void main(String args[]) {
        MinimumDistanceBetweenBSTNodes mdbbn = new MinimumDistanceBetweenBSTNodes();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(mdbbn.minDiffInBST(root));
    }
}
