
import java.util.Stack;

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        int sum = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }
        return root;
    }

    public static void main(String args[]) {
        ConvertBSTtoGreaterTree cbgt = new ConvertBSTtoGreaterTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(cbgt.convertBST(root));
    }
}
