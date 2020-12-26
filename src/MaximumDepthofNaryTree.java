
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree {

    class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node curr = queue.poll();
                List<Node> children = curr.children;
                for (int i = 0; i < children.size(); i++) {
                    if (children.get(i) != null) {
                        queue.add(children.get(i));
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
