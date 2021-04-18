
import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int max = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] > coins) {
                return max;
            }
            coins -= costs[i];
            max++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumIceCreamBars mib = new MaximumIceCreamBars();
        int[] costs = new int[]{1, 3, 2, 4, 1};
        System.out.println(mib.maxIceCream(costs, 7));
    }
}
