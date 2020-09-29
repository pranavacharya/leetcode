
import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<Integer> list = new LinkedList();
        dfs(root, list);
        list.poll();
        while (!list.isEmpty()) {
            root.right = new TreeNode(list.poll());
            root = root.right;
        }
    }

    private void dfs(TreeNode root, Queue<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, list);
        }
        root.left = null;
        if (root.right != null) {
            dfs(root.right, list);
        }
        root.right = null;
    }

    public static void main(String args[]) {
        FlattenBinaryTreetoLinkedList fbtll = new FlattenBinaryTreetoLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        fbtll.flatten(root);
        System.out.println(root);
    }
}
