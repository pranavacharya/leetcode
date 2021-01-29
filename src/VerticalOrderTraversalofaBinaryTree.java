
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree {

    class Node {

        private TreeNode root;
        private int index;

        public Node(TreeNode r, int i) {
            this.root = r;
            this.index = i;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        Queue<Node> queue = new LinkedList();
        if (root == null) {
            return new ArrayList();
        }
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashMap<Integer, List<Integer>> temp = new HashMap();
            while (size > 0) {
                Node curr = queue.poll();
                List<Integer> templist = temp.getOrDefault(curr.index, new ArrayList());
                templist.add(curr.root.val);
                temp.put(curr.index, templist);
                if (curr.root.left != null) {
                    queue.add(new Node(curr.root.left, curr.index - 1));
                }
                if (curr.root.right != null) {
                    queue.add(new Node(curr.root.right, curr.index + 1));
                }
                size--;
            }
            for (int key : temp.keySet()) {
                List<Integer> templist = temp.get(key);
                Collections.sort(templist);
                List<Integer> list = map.getOrDefault(key, new ArrayList());
                list.addAll(templist);
                map.put(key, list);
            }
        }
        List<List<Integer>> result = new ArrayList();
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            result.add(list);
        }
        return result;
    }

    public static void main(String args[]) {
        VerticalOrderTraversalofaBinaryTree votbt = new VerticalOrderTraversalofaBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(votbt.verticalTraversal(root));
    }
}
