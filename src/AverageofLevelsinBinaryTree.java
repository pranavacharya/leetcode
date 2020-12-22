
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nodes = size;
            double sum = 0;
            while (size > 0) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            result.add(sum / nodes);
        }
        return result;
    }

    public static void main(String args[]) {
        AverageofLevelsinBinaryTree albt = new AverageofLevelsinBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(albt.averageOfLevels(root));
    }
}
