
public class ClosestDessertCost {

    private int closest = Integer.MAX_VALUE;
    private int closestVal = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int i = 0; i < baseCosts.length; i++) {
            backTracking(toppingCosts, target, baseCosts[i], 0);
        }
        return closestVal;
    }

    private void backTracking(int[] toppingsCost, int target, int sum, int index) {
        int localDiff = Math.abs(target - sum);
        if (localDiff < closest) {
            closestVal = sum;
            closest = localDiff;
        } else if (localDiff == closest && sum < closestVal) {
            closestVal = sum;
        }
        if (index == toppingsCost.length) {
            return;
        }
        backTracking(toppingsCost, target, sum, index + 1);
        backTracking(toppingsCost, target, sum + toppingsCost[index], index + 1);
        backTracking(toppingsCost, target, sum + (2 * toppingsCost[index]), index + 1);
    }

    public static void main(String[] args) {
        ClosestDessertCost cdc = new ClosestDessertCost();
        int[] baseCosts = new int[]{3, 10, 5, 6, 7, 8, 1, 2};
        int[] toppingCosts = new int[]{2, 5, 6, 4, 8, 9, 1, 3,};
        System.out.println(cdc.closestCost(baseCosts, toppingCosts, 9));
    }
}
