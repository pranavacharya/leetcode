
import java.util.ArrayList;
import java.util.List;


public class FindLeavesofBinaryTree {

    List<List<Integer>> result;

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.result = new ArrayList();
        helper(root);
        return this.result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        if (this.result.size() <= left) {
            this.result.add(new ArrayList());
        }

        int right = helper(root.right);
        if (this.result.size() <= right) {
            this.result.add(new ArrayList());
        }

        this.result.get(Math.max(left, right)).add(root.val);

        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
        FindLeavesofBinaryTree flbt = new FindLeavesofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(flbt.findLeaves(root));
    }
}
