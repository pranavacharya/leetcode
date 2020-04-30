
import java.util.ArrayList;

public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return false;
        }
        ArrayList<Integer> path = new ArrayList();
        path.add(root.val);
        return dfs(root, arr, path);
    }

    public boolean dfs(TreeNode root, int[] arr, ArrayList<Integer> path) {
        if (root.left == null && root.right == null && path.size() == arr.length) {
            for (int i = 0; i < path.size(); i++) {
                if (arr[i] != path.get(i)) {
                    return false;
                }
            }
            return true;
        } else {
            boolean status = false;
            if (root.left != null) {
                path.add(root.left.val);
                if (path.size() > arr.length) {
                    path.remove(path.size() - 1);
                    return false;
                }
                status = dfs(root.left, arr, path);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right.val);
                if (path.size() > arr.length) {
                    path.remove(path.size() - 1);
                    return false;
                }
                status = status || dfs(root.right, arr, path);
                path.remove(path.size() - 1);
            }
            return status;
        }
    }

    public static void main(String args[]) {
        CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree cvs = new CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        int[] arr = new int[]{0, 0, 0};
        System.out.println(cvs.isValidSequence(root, arr));
    }
}
