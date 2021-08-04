
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        helper(result, root, targetSum, 0, new ArrayList());
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int targetSum, int sum, List<Integer> path) {
        sum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == sum) {
                result.add(new ArrayList(path));
            }
            sum -= root.val;
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            helper(result, root.left, targetSum, sum, path);
        }

        if (root.right != null) {
            helper(result, root.right, targetSum, sum, path);
        }
        sum -= root.val;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        PathSum2 ps2 = new PathSum2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(ps2.pathSum(root, 22));
    }
}
