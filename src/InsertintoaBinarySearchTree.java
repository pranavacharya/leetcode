
public class InsertintoaBinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode head = root;
        helper(head, val);
        return root;
    }

    private void helper(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            if (val > root.val) {
                root.right = new TreeNode(val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (val > root.val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    helper(root.right, val);
                }
            } else {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    helper(root.left, val);
                }
            }
        }
    }

    public static void main(String args[]) {
        InsertintoaBinarySearchTree ibst = new InsertintoaBinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root = ibst.insertIntoBST(root, 5);
        System.out.println(root);
    }
}
