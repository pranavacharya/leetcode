
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        dfs(root, targetSum, result, new ArrayList());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        targetSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum, result, path);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, result, path);
        }
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
