
import java.util.HashSet;

public class TwoSumIVInputisaBST {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, new HashSet(), k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int target) {
        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(target - root.val);
            if (root.left != null) {
                if (dfs(root.left, set, target)) {
                    return true;
                }
            }
            if (root.right != null) {
                if (dfs(root.right, set, target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        TwoSumIVInputisaBST ts = new TwoSumIVInputisaBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(ts.findTarget(root, 9));
    }
}
