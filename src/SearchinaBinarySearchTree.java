
public class SearchinaBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ans = dfs(root, val);
        return ans;
    }

    public TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return dfs(root.left, val);
        } else {
            return dfs(root.right, val);
        }
    }

    public static void main(String args[]) {
        SearchinaBinarySearchTree sbt = new SearchinaBinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(sbt.searchBST(root, 6).val);
    }
}
