
public class LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootv = root.val;
        int pv = p.val;
        int qv = q.val;
        if (pv > rootv && qv > rootv) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pv < rootv && qv < rootv) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

}
