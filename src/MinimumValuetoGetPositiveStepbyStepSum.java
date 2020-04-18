
public class MinimumValuetoGetPositiveStepbyStepSum {

    public int minStartValue(int[] nums) {
        int i = 1;
        while (true) {
            int sum = i;
            boolean status = true;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (sum < 1) {
                    status = false;
                    break;
                }
            }
            if (status) {
                return i;
            }
            i++;
        }
    }

    public static void main(String args[]) {
        MinimumValuetoGetPositiveStepbyStepSum mvpss = new MinimumValuetoGetPositiveStepbyStepSum();
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        System.out.println(mvpss.minStartValue(nums));
    }
}
