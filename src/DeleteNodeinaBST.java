
public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int inorderSuccessor(TreeNode root) {
        if (root.left == null) {
            return root.val;
        } else {
            return inorderSuccessor(root.left);
        }
    }

    public static void main(String args[]) {
        DeleteNodeinaBST dnib = new DeleteNodeinaBST();
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(7);
        head = dnib.deleteNode(head, 3);
        System.out.println(head);
    }
}
