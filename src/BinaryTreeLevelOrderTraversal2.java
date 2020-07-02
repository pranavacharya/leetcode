
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeLevelOrderTraversal2 {

    public class nodeLevel {

        TreeNode node;
        int level;

        nodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        Queue<nodeLevel> queue = new LinkedList();
        queue.add(new nodeLevel(root, 0));
        while (!queue.isEmpty()) {
            nodeLevel curr = queue.poll();
            List<Integer> temp = map.getOrDefault(curr.level, new ArrayList());
            temp.add(curr.node.val);
            map.put(curr.level, temp);
            if (curr.node.left != null) {
                queue.add(new nodeLevel(curr.node.left, curr.level + 1));
            }
            if (curr.node.right != null) {
                queue.add(new nodeLevel(curr.node.right, curr.level + 1));
            }
        }

        List<List<Integer>> result = new ArrayList();
        while (!map.isEmpty()) {
            int last = map.lastKey();
            result.add(map.get(last));
            map.remove(last);
        }
        return result;
    }

    public static void main(String args[]) {
        BinaryTreeLevelOrderTraversal2 btlot2 = new BinaryTreeLevelOrderTraversal2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(btlot2.levelOrderBottom(root));
    }
}
