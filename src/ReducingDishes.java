
import java.util.Arrays;

public class ReducingDishes {

    private int[][] dp;

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        this.dp = new int[satisfaction.length + 1][satisfaction.length + 1];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(satisfaction, 0, 1);
    }

    private int helper(int[] satisfaction, int index, int count) {
        if (index == satisfaction.length) {
            return 0;
        }
        if (this.dp[index][count] != -1) {
            return this.dp[index][count];
        }
        int max = 0;
        max = Math.max(max, satisfaction[index] * count + helper(satisfaction, index + 1, count + 1));
        max = Math.max(max, helper(satisfaction, index + 1, count));
        return this.dp[index][count] = max;
    }

    public static void main(String[] args) {
        ReducingDishes rd = new ReducingDishes();
        int[] satisfaction = new int[]{-1, -8, 0, 5, -9};
        System.out.println(rd.maxSatisfaction(satisfaction));
    }
}
