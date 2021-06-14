
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        return deepestSum(root)[1];
    }

    private int[] deepestSum(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{1, root.val};
        }
        int[] left = deepestSum(root.left);
        int[] right = deepestSum(root.right);
        if (left[0] == right[0]) {
            return new int[]{left[0] + 1, left[1] + right[1]};
        }
        if (left[0] > right[0]) {
            return new int[]{left[0] + 1, left[1]};
        } else {
            return new int[]{right[0] + 1, right[1]};
        }
    }

    public static void main(String[] args) {
        DeepestLeavesSum dls = new DeepestLeavesSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(dls.deepestLeavesSum(root));
    }
}
