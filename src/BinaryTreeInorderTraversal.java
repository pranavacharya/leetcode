
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        } else {
            dfs(root.left, result);
            result.add(root.val);
            dfs(root.right, result);
        }
    }

    public static void main(String args[]) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(btit.inorderTraversal(root));
    }

}
