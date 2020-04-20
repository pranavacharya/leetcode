
public class ConstructBinarySearchTreefromPreorderTraversal {

    public void insertNode(TreeNode root, int node) {
        TreeNode head = root;
        while (head != null) {
            if (head.val == node) {
                return;
            }
            if (head.val > node) {
                if (head.left == null) {
                    head.left = new TreeNode(node);
                    break;
                }
                head = head.left;
            }
            if (head.val < node) {
                if (head.right == null) {
                    head.right = new TreeNode(node);
                    break;
                }
                head = head.right;
            }
        }
    }

    public TreeNode createBST(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        for (int node : nodes) {
            insertNode(root, node);
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = createBST(preorder);
        return root;
    }

    public static void main(String args[]) {
        ConstructBinarySearchTreefromPreorderTraversal cbst = new ConstructBinarySearchTreefromPreorderTraversal();
        int[] nodes = new int[]{8, 5, 1, 7, 10, 12};
        System.out.println(cbst.bstFromPreorder(nodes));
    }
}
