
import java.util.HashMap;

public class PseudoPalindromicPathsinaBinaryTree {

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        this.count = 0;
        if (root == null) {
            return this.count;
        }
        dfs(root, new HashMap());
        return this.count;
    }

    private void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null && isPseudoPalindrome(map)) {
            this.count++;
        }
        if (root.left != null) {
            dfs(root.left, map);
        }
        if (root.right != null) {
            dfs(root.right, map);
        }
        map.put(root.val, map.get(root.val) - 1);
        if (map.get(root.val) == 0) {
            map.remove(root.val);
        }
    }

    private boolean isPseudoPalindrome(HashMap<Integer, Integer> map) {
        int odd = 0;
        for (int key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odd++;
            }
        }
        return odd == 0 || odd == 1;
    }

    public static void main(String args[]) {
        PseudoPalindromicPathsinaBinaryTree pppibt = new PseudoPalindromicPathsinaBinaryTree();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        System.out.println(pppibt.pseudoPalindromicPaths(root));
    }
}
