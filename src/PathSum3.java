
import java.util.ArrayList;

public class PathSum3 {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        dfs(root, sum, prefixSum);
        return count;
    }

    public void dfs(TreeNode root, int sum, ArrayList<Integer> prefixSum) {
        if (root == null) {
            return;
        } else {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + root.val);
            for (int i = 0; i < prefixSum.size() - 1; i++) {
                if (prefixSum.get(prefixSum.size() - 1) - prefixSum.get(i) == sum) {
                    this.count++;
                }
            }
            dfs(root.left, sum, prefixSum);
            dfs(root.right, sum, prefixSum);
            prefixSum.remove(prefixSum.size() - 1);
        }
    }

    public static void main(String args[]) {
        PathSum3 ps3 = new PathSum3();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(ps3.pathSum(root, 8));
    }
}
