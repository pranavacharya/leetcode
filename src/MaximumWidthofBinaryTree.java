
import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidht = 0;
        Deque<TreeNode> bfs = new LinkedList();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            maxWidht = Math.max(maxWidht, bfs.size());
            int size = bfs.size();
            while (size > 0) {
                TreeNode curr = bfs.poll();
                if (curr == null) {
                    bfs.add(null);
                    bfs.add(null);
                } else {
                    bfs.add(curr.left);
                    bfs.add(curr.right);
                }
                size--;
            }
            while (!bfs.isEmpty() && bfs.peekFirst() == null) {
                bfs.pollFirst();
            }
            while (!bfs.isEmpty() && bfs.peekLast() == null) {
                bfs.pollLast();
            }
        }
        return maxWidht;
    }

    public static void main(String args[]) {
        MaximumWidthofBinaryTree mwbt = new MaximumWidthofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(mwbt.widthOfBinaryTree(root));
    }
}
