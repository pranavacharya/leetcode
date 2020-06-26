
import java.util.ArrayList;

public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        ArrayList<String> result = new ArrayList();
        if (root == null) {
            return 0;
        }
        dfs(result, "", root);
        int sum = 0;
        for (String num : result) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public void dfs(ArrayList<String> result, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(path.concat(Integer.toString(root.val)));
            return;
        } else {
            path = path.concat(Integer.toString(root.val));
            if (root.left != null) {
                dfs(result, path, root.left);
            }
            if (root.right != null) {
                dfs(result, path, root.right);
            }
            path = path.substring(0, path.length() - 1);
        }
    }

    public static void main(String args[]) {
        SumRoottoLeafNumbers srtln = new SumRoottoLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(srtln.sumNumbers(root));
    }
}
