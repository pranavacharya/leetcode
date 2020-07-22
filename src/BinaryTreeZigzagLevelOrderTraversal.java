
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean asc = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList();
            while (size > 0) {
                TreeNode curr = queue.poll();
                row.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            if (!asc) {
                Collections.reverse(row);
            }
            asc = !asc;
            result.add(row);
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
