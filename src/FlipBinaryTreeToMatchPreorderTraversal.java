
import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {

    private int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        if (root.val != voyage[0]) {
            list.add(-1);
            return list;
        }
        dfs(root, voyage, list);
        if (!list.isEmpty() && list.get(0) == -1) {
            list.clear();
            list.add(-1);
        }
        return list;
    }

    private void dfs(TreeNode root, int[] voyage, List<Integer> result) {
        if (index == voyage.length || root == null) {
            return;
        }

        if (root.val != voyage[index++]) {
            result.clear();
            result.add(-1);
            return;
        }

        if (root.left != null && root.left.val != voyage[index]) {
            result.add(root.val);
            dfs(root.right, voyage, result);
            dfs(root.left, voyage, result);
            return;
        } else {
            dfs(root.left, voyage, result);
            dfs(root.right, voyage, result);
        }
    }

    public static void main(String[] args) {
        FlipBinaryTreeToMatchPreorderTraversal fbtmpt = new FlipBinaryTreeToMatchPreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[] voyage = new int[]{1, 3, 2};
        System.out.println(fbtmpt.flipMatchVoyage(root, voyage));
    }
}
