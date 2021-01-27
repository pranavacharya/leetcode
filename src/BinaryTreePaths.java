
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if (root == null) {
            return list;
        }
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String path) {
        if (root.left == null && root.right == null) {
            if (!path.isEmpty()) {
                path = path.concat("->");
            }
            path = path.concat("" + root.val);
            list.add(path);
            return;
        }
        if (!path.isEmpty()) {
            path = path.concat("->");
        }
        path = path.concat("" + root.val);

        if (root.left != null) {
            dfs(root.left, list, path);
        }
        if (root.right != null) {
            dfs(root.right, list, path);
        }

    }

    public static void main(String args[]) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(btp.binaryTreePaths(root));
    }
}
