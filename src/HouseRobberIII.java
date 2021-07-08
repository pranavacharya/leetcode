
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] helper(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] ans = new int[2];

        // ans[0] = robbed
        // ans[1] = not robbed
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        ans[0] = root.val + left[1] + right[1];

        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ans;
    }

    public static void main(String args[]) {
        HouseRobberIII hr = new HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        System.out.println(hr.rob(root));
    }
}
