
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int ans = 1;
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        pos[0] = 1;
        neg[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] > 0) {
                    pos[i] = Math.max(pos[i], neg[j] + 1);
                } else if (nums[i] - nums[j] < 0) {
                    neg[i] = Math.max(neg[i], pos[j] + 1);
                } else {
                    pos[i] = Math.max(pos[i], 1);
                    neg[i] = Math.max(neg[i], 1);
                }
            }
            ans = Math.max(ans, Math.max(pos[i], neg[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        WiggleSubsequence ws = new WiggleSubsequence();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(ws.wiggleMaxLength(nums));
    }
}
