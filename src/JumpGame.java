
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String args[]) {
        JumpGame jg = new JumpGame();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.canJump(nums));
    }
}
