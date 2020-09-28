
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        SubarrayProductLessThanK spltk = new SubarrayProductLessThanK();
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println(spltk.numSubarrayProductLessThanK(nums, 100));
    }
}
