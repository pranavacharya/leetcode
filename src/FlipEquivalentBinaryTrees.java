
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null && root2 != null) {
            return false;
        }

        if (root1 != null && root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        if ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        FlipEquivalentBinaryTrees febt = new FlipEquivalentBinaryTrees();
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(1);
        System.out.println(febt.flipEquiv(root1, root2));
    }
}
