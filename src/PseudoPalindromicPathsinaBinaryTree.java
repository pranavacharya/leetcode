
import java.util.HashMap;

public class PseudoPalindromicPathsinaBinaryTree {

    private int count;

    public PseudoPalindromicPathsinaBinaryTree() {
        this.count = 0;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1, new HashMap());
        return this.count;
    }

    public void dfs(TreeNode root, int depth, HashMap<Integer, Integer> frequency) {
        if (root.left == null && root.right == null) {
            frequency.put(root.val, frequency.getOrDefault(root.val, 0) + 1);
            if (ispseudoPalindrome(frequency, depth)) {
                this.count++;
            }
            frequency.put(root.val, frequency.getOrDefault(root.val, 0) - 1);
            if (frequency.get(root.val) == 0) {
                frequency.remove(root.val);
            }
        } else {
            frequency.put(root.val, frequency.getOrDefault(root.val, 0) + 1);
            if (root.left != null) {
                dfs(root.left, depth + 1, frequency);
            }
            if (root.right != null) {
                dfs(root.right, depth + 1, frequency);
            }
            frequency.put(root.val, frequency.get(root.val) - 1);
            if (frequency.get(root.val) == 0) {
                frequency.remove(root.val);
            }
        }
    }

    public boolean ispseudoPalindrome(HashMap<Integer, Integer> frequency, int depth) {
        int oddNumbers = 0;
        for (int key : frequency.keySet()) {
            if (frequency.get(key) % 2 == 1) {
                oddNumbers++;
            }
        }
        return !((depth % 2 == 0 && oddNumbers > 0) || (depth % 2 == 1 && oddNumbers > 1));
    }

    public static void main(String args[]) {
        PseudoPalindromicPathsinaBinaryTree pppibt = new PseudoPalindromicPathsinaBinaryTree();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        System.out.println(pppibt.pseudoPalindromicPaths(null));
    }
}
