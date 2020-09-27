
public class MaximumProfitofOperatingaCentennialWheel {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int queue = 0;
        int maxProfit = -1;
        int maxProfitIndex = -1;
        int processed = 0;
        int i = 0;
        for (i = 0; i < customers.length; i++) {
            queue += customers[i];
            if (queue > 4) {
                queue -= 4;
                processed += 4;
            } else {
                processed += queue;
                queue = 0;
            }
            int profit = processed * boardingCost - (i + 1) * runningCost;
            if (maxProfit < profit) {
                maxProfit = profit;
                maxProfitIndex = i + 1;
            }
        }

        while (queue > 0) {
            if (queue > 4) {
                queue -= 4;
                processed += 4;
            } else {
                processed += queue;
                queue = 0;
            }
            int profit = processed * boardingCost - (i + 1) * runningCost;
            if (maxProfit < profit) {
                maxProfit = profit;
                maxProfitIndex = i + 1;
            }
            i++;
        }

        return maxProfitIndex;
    }

    public static void main(String args[]) {
        MaximumProfitofOperatingaCentennialWheel mpocw = new MaximumProfitofOperatingaCentennialWheel();
        int[] customers = new int[]{8, 3};
        System.out.println(mpocw.minOperationsMaxProfit(customers, 5, 6));
    }
}
