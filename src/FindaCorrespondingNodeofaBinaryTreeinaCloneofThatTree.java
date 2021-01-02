
import java.util.LinkedList;
import java.util.Queue;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode[]> queue = new LinkedList();
        queue.add(new TreeNode[]{original, cloned});
        while (!queue.isEmpty()) {
            TreeNode[] curr = queue.poll();
            if (curr[0] == target) {
                return curr[1];
            }
            if (curr[0].left != null) {
                queue.add(new TreeNode[]{curr[0].left, curr[1].left});
            }
            if (curr[1].right != null) {
                queue.add(new TreeNode[]{curr[0].right, curr[1].right});
            }
        }
        return null;
    }
}
