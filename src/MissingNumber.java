
public class MissingNumber {

    public int missingNumber(int[] nums) {
        boolean last = false;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) == nums.length) {
                last = true;
            } else {
                nums[Math.abs(nums[i])] *= -1;
            }
        }
        int zeroindex = -1;
        if (!last) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i;
                } else if (nums[i] == 0) {
                    zeroindex = i;
                }
            }
        }
        return zeroindex;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        int[] nums = new int[]{1, 2};
        System.out.println(mn.missingNumber(nums));
    }
}
