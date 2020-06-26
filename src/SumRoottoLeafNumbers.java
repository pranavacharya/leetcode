
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        } else {
            sum = sum * 10 + root.val;
            int ans = 0;
            if (root.left != null) {
                ans += dfs(root.left, sum);
            }
            if (root.right != null) {
                ans += dfs(root.right, sum);
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        SumRoottoLeafNumbers srtln = new SumRoottoLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(srtln.sumNumbers(root));
    }
}
