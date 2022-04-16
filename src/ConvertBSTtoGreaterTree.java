

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }
    
    private int convert(TreeNode root, int rightSum) {
        if(root == null) {
            return 0;
        }
        
        int sum = root.val;
        
        sum += convert(root.right, rightSum);
        
        root.val = sum + rightSum;
                
        sum += convert(root.left, rightSum + sum);
        
        return sum;
    }

    public static void main(String args[]) {
        ConvertBSTtoGreaterTree cbgt = new ConvertBSTtoGreaterTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        cbgt.convertBST(root);
        System.out.println(root);
    }
}
