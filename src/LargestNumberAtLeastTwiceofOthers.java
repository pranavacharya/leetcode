
public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != index && 2 * nums[i] > max) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        LargestNumberAtLeastTwiceofOthers lnatoo = new LargestNumberAtLeastTwiceofOthers();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(lnatoo.dominantIndex(nums));
    }
}
