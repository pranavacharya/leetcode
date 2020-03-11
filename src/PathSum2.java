
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return this.result;
        }
        dfs(root, new ArrayList<>(), 0, sum);
        return this.result;
    }

    public void dfs(TreeNode root, ArrayList<Integer> tillnow, int total, int sum) {
        if (root == null) {
            return;
        }
        total = total + root.val;
        tillnow.add(root.val);
        if (root.left == null && root.right == null) {
            if (total == sum) {
                this.result.add(tillnow);
            }
        } else {
            ArrayList<Integer> leftbranch = (ArrayList<Integer>) tillnow.clone();
            ArrayList<Integer> rightbranch = (ArrayList<Integer>) tillnow.clone();
            dfs(root.left, leftbranch, total, sum);
            dfs(root.right, rightbranch, total, sum);
        }
    }
}
