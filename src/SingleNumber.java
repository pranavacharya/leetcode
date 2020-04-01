
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        SingleNumber sn = new SingleNumber();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(sn.singleNumber(nums));
    }
}
