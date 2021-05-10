
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllElementsinTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        inorder(root1, queue1);
        inorder(root2, queue2);
        List<Integer> result = new ArrayList();

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                result.add(queue2.poll());
            } else if (queue2.isEmpty()) {
                result.add(queue1.poll());
            } else {
                result.add(queue1.peek() > queue2.peek() ? queue2.poll() : queue1.poll());
            }
        }
        return result;
    }

    private void inorder(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        inorder(root.left, queue);
        queue.add(root.val);
        inorder(root.right, queue);
    }

    public static void main(String[] args) {
        AllElementsinTwoBinarySearchTrees aeitbst = new AllElementsinTwoBinarySearchTrees();
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(4);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(0);
        tree2.right = new TreeNode(3);
        System.out.println(aeitbst.getAllElements(tree1, tree2));
    }
}
