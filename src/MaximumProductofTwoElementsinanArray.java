
public class MaximumProductofTwoElementsinanArray {

    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (firstMax < nums[i]) {
                firstMax = nums[i];
                j = i;
            }
        }
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (secondMax < nums[i] && j != i) {
                secondMax = nums[i];
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }

    public static void main(String args[]) {
        MaximumProductofTwoElementsinanArray mpte = new MaximumProductofTwoElementsinanArray();
        int[] nums = new int[]{3, 4, 5, 2};
        System.out.println(mpte.maxProduct(nums));
    }
}
