
import java.util.Arrays;

public class ReducingDishes {

    private int max = 0;

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        helper(satisfaction, 0, 1, 0);
        return this.max;
    }

    private void helper(int[] satisfaction, int index, int count, int sum) {
        if (index == satisfaction.length) {
            this.max = Math.max(this.max, sum);
            return;
        }
        helper(satisfaction, index + 1, count + 1, sum + satisfaction[index] * count);
        helper(satisfaction, index + 1, count, sum);
    }

    public static void main(String[] args) {
        ReducingDishes rd = new ReducingDishes();
        int[] satisfaction = new int[]{-1, -8, 0, 5, -9};
        System.out.println(rd.maxSatisfaction(satisfaction));
    }
}
