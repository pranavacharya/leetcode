
import java.util.ArrayList;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList();
        if (root1 != null) {
            dfs(root1, list1);
        }
        ArrayList<Integer> list2 = new ArrayList();
        if (root2 != null) {
            dfs(root2, list2);
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, list);
        }

        if (root.right != null) {
            dfs(root.right, list);
        }
    }

    public static void main(String args[]) {
        LeafSimilarTrees lst = new LeafSimilarTrees();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        System.out.println(lst.leafSimilar(root1, root2));
    }
}
