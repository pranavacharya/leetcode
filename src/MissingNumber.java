
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ i;
            n = n ^ nums[i];
        }
        return n;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        int[] nums = new int[]{1, 2};
        System.out.println(mn.missingNumber(nums));
    }
}
