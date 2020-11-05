
import java.util.HashMap;

public class MinimumCosttoMoveChipstoTheSamePosition {

    public int minCostToMoveChips(int[] position) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < position.length; i++) {
            freq.put(position[i], freq.getOrDefault(position[i], 0) + 1);
        }
        int minCost = Integer.MAX_VALUE;
        for (int i : freq.keySet()) {
            int cost = 0;
            for (int j : freq.keySet()) {
                if (i == j) {
                    continue;
                }
                if (i % 2 != j % 2) {
                    cost += freq.get(j);
                }
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static void main(String args[]) {
        MinimumCosttoMoveChipstoTheSamePosition mctnctsp = new MinimumCosttoMoveChipstoTheSamePosition();
        int[] positions = new int[]{2, 2, 2, 3, 3};
        System.out.println(mctnctsp.minCostToMoveChips(positions));
    }
}
