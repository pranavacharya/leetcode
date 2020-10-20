
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node head = new Node();
        HashMap<Integer, Node> map = new HashMap();
        dfs(node, head, map);
        return head;
    }

    private void dfs(Node node, Node head, HashMap<Integer, Node> map) {
        head.val = node.val;
        map.put(node.val, head);
        for (Node neighbour : node.neighbors) {
            if (map.containsKey(neighbour.val)) {
                head.neighbors.add(map.get(neighbour.val));
            } else {
                Node current = new Node();
                head.neighbors.add(current);
                dfs(neighbour, current, map);
            }

        }
    }

}
