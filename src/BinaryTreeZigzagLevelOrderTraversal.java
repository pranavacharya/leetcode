
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList();
            while (!stack1.isEmpty()) {
                TreeNode curr = stack1.pop();
                temp.add(curr.val);
                if (curr.left != null) {
                    stack2.push(curr.left);
                }
                if (curr.right != null) {
                    stack2.push(curr.right);
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
            temp = new ArrayList();
            while (!stack2.isEmpty()) {
                TreeNode curr = stack2.pop();
                temp.add(curr.val);
                if (curr.right != null) {
                    stack1.push(curr.right);
                }
                if (curr.left != null) {
                    stack1.push(curr.left);
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        BinaryTreeZigzagLevelOrderTraversal btzzlot = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(btzzlot.zigzagLevelOrder(root));
    }
}
