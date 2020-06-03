
import java.util.PriorityQueue;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Math.abs(costs[b][0] - costs[b][1]) - Math.abs(costs[a][0] - costs[a][1]));
        for (int i = 0; i < costs.length; i++) {
            maxHeap.add(i);
        }
        int sum = 0;
        int setA = 0;
        int setB = 0;
        while (!maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            if (costs[current][0] < costs[current][1]) {
                if (setA != costs.length / 2) {
                    sum += costs[current][0];
                    setA++;
                } else {
                    sum += costs[current][1];
                    setB++;
                }
            } else {
                if (setB != costs.length / 2) {
                    sum += costs[current][1];
                    setB++;
                } else {
                    sum += costs[current][0];
                    setA++;
                }
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        TwoCityScheduling tcs = new TwoCityScheduling();
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(tcs.twoCitySchedCost(costs));
    }
}
