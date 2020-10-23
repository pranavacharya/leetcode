
public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] < nums[j] && nums[i] < nums[k]) {
                            return true;
                        }
                    }
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
