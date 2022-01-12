
public class SumofRootToLeafBinaryNumbers {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return sum;
    }

    private void helper(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            num = num << 1;
            num += root.val;
            sum += num;
            return;
        }

        num = num << 1;
        num += root.val;

        if (root.left != null) {
            helper(root.left, num);
        }

        if (root.right != null) {
            helper(root.right, num);
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
