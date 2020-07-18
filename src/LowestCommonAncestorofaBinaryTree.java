
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (dfs(curr, p) && dfs(curr, q)) {
                ans = curr;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode key) {
        if (root == null) {
            return false;
        } else if (root == key) {
            return true;
        } else {
            return dfs(root.left, key) || dfs(root.right, key);
        }
    }

    public static void main(String args[]) {
        LowestCommonAncestorofaBinaryTree lcaobt = new LowestCommonAncestorofaBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(lcaobt.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
