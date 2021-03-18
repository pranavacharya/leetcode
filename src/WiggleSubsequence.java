
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        pos[0] = 1;
        neg[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                pos[i] = neg[i - 1] + 1;
                neg[i] = neg[i - 1];
            } else if (nums[i] - nums[i - 1] < 0) {
                neg[i] = pos[i - 1] + 1;
                pos[i] = pos[i - 1];
            } else {
                pos[i] = pos[i - 1];
                neg[i] = neg[i - 1];
            }
        }
        return Math.max(pos[nums.length - 1], neg[nums.length - 1]);
    }

    public static void main(String[] args) {
        WiggleSubsequence ws = new WiggleSubsequence();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(ws.wiggleMaxLength(nums));
    }
}
