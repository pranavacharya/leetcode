
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (size > 0) {
                TreeNode current = queue.poll();
                if (current == null) {
                    list.add(null);
                } else {
                    list.add(current.val);
                }
                if (current != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                }
                size--;
            }
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                if (Objects.equals(list.get(i), list.get(j))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(st.isSymmetric(root));
    }
}
