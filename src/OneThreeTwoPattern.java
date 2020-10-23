
public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > min && nums[i] > nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        OneThreeTwoPattern ottp = new OneThreeTwoPattern();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(ottp.find132pattern(nums));
    }
}
