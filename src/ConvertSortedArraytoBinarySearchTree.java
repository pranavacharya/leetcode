
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree csabst = new ConvertSortedArraytoBinarySearchTree();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(csabst.sortedArrayToBST(nums));
    }
}
