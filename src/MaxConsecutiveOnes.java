
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int local = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                local++;
                max = Math.max(max, local);
            } else {
                local = 0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(mco.findMaxConsecutiveOnes(nums));
    }
}
