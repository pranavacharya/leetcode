
import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            while (size > 0) {
                TreeNode curr = queue.poll();
                if (curr.val == x) {
                    xFound = true;
                }
                if (curr.val == y) {
                    yFound = true;
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                size--;
            }
            if (xFound && yFound) {
                return true;
            } else if ((xFound && !yFound) || (!xFound && yFound)) {
                return false;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CousinsinBinaryTree cibt = new CousinsinBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(cibt.isCousins(root, 2, 3));
    }
}
