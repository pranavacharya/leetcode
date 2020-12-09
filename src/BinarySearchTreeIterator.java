
import java.util.Stack;

public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    private void addLeftSubTree() {
        while (this.stack.peek().left != null) {
            this.stack.add(stack.peek().left);
        }
    }

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack();
        this.stack.push(root);
        addLeftSubTree();
    }

    public int next() {
        TreeNode curr = this.stack.pop();
        if (curr.right != null) {
            this.stack.push(curr.right);
            addLeftSubTree();
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BinarySearchTreeIterator bsti = new BinarySearchTreeIterator(root);
        System.out.println(bsti.next());
        System.out.println(bsti.next());
        System.out.println(bsti.hasNext());
        System.out.println(bsti.next());
        System.out.println(bsti.hasNext());
        System.out.println(bsti.next());
        System.out.println(bsti.hasNext());
        System.out.println(bsti.next());
        System.out.println(bsti.hasNext());
    }
}
