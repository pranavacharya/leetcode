
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }
        int count = 0;
        int start = 0;
        int end = 0;
        int product = 1;
        while (end < nums.length) {
            product *= nums[end];
            while (product >= k) {
                product /= nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }

    public static void main(String args[]) {
        SubarrayProductLessThanK spltk = new SubarrayProductLessThanK();
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println(spltk.numSubarrayProductLessThanK(nums, 100));
    }
}
