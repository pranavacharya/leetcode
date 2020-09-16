
public class MaximumXORofTwoNumbersinanArray {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumXORofTwoNumbersinanArray mxtna = new MaximumXORofTwoNumbersinanArray();
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(mxtna.findMaximumXOR(nums));
    }
}
