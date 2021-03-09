
import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            root = temp;
            return root;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                if (depth == d - 1) {
                    TreeNode leftTree = new TreeNode(v);
                    TreeNode rightTree = new TreeNode(v);
                    leftTree.left = curr.left;
                    rightTree.right = curr.right;
                    curr.left = leftTree;
                    curr.right = rightTree;
                } else {
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
                size--;
            }
            depth++;
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRowtoTree aort = new AddOneRowtoTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        System.out.println(aort.addOneRow(root, 1, 3));
    }
}
