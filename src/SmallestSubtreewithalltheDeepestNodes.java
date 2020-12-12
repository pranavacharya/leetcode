
import java.util.LinkedList;
import java.util.Queue;

public class SmallestSubtreewithalltheDeepestNodes {

    private int maxDepth;
    private int maxDepthCount;
    private TreeNode ans;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        this.ans = null;
        bfs(root);
        dfs(root, 0);
        return ans;
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 0;
        int maxDepthCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepthCount = size;
            while (size > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            if (!queue.isEmpty()) {
                depth++;
            }
        }
        this.maxDepth = depth;
        this.maxDepthCount = maxDepthCount;
    }

    private int[] dfs(TreeNode root, int currDepth) {
        if (root.left == null && root.right == null) {
            if (currDepth + 0 == maxDepth && maxDepthCount == 1 && this.ans == null) {
                this.ans = root;
            }
            return new int[]{0, 1};
        } else {
            int[] left = new int[]{0, 0};
            if (root.left != null) {
                left = dfs(root.left, currDepth + 1);
            }
            int[] right = new int[]{0, 0};
            if (root.right != null) {
                right = dfs(root.right, currDepth + 1);
            }
            int noOfDepthNode = 0;
            int belowDepth = 0;
            if (left[0] == right[0]) {
                noOfDepthNode = left[1] + right[1];
                belowDepth = left[0] + 1;
            } else {
                if (left[0] > right[0]) {
                    noOfDepthNode = left[1];
                    belowDepth = left[0] + 1;
                } else {
                    noOfDepthNode = right[1];
                    belowDepth = right[0] + 1;
                }
            }
            if (currDepth + belowDepth == maxDepth && maxDepthCount == noOfDepthNode && this.ans == null) {
                this.ans = root;
            }
            return new int[]{belowDepth, noOfDepthNode};
        }
    }

    public static void main(String args[]) {
        SmallestSubtreewithalltheDeepestNodes sswadp = new SmallestSubtreewithalltheDeepestNodes();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(sswadp.subtreeWithAllDeepest(root));
    }
}
