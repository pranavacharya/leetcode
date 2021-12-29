
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            while (size > 0) {
                Node curr = queue.poll();
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (last != null) {
                    curr.next = last;
                }
                last = curr;
                size--;
            }
        }
        return root;
    }

}
