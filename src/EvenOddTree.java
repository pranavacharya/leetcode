
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean isEven = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer last = null;
            while (size > 0) {
                TreeNode current = queue.poll();
                size--;
                if (isEven) {
                    if (current.val % 2 == 0) {
                        return false;
                    }
                    if (last != null) {
                        if (last >= current.val) {
                            return false;
                        } else {
                            last = current.val;
                        }
                    } else {
                        last = current.val;
                    }
                } else {
                    if (current.val % 2 == 1) {
                        return false;
                    }
                    if (last != null) {
                        if (last <= current.val) {
                            return false;
                        } else {
                            last = current.val;
                        }
                    } else {
                        last = current.val;
                    }
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            isEven = !isEven;
        }
        return true;
    }

    public static void main(String args[]) {
        EvenOddTree eot = new EvenOddTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);
        System.out.println(eot.isEvenOddTree(root));
    }
}
