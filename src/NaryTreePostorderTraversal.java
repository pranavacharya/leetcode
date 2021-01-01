
import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

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

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), list);
        }
        list.add(root.val);
    }

}
