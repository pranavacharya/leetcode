
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityofRocks {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> (capacity[a] - rocks[a]) - (capacity[b] - rocks[b]));
        for (int i = 0; i < rocks.length; i++) {
            minHeap.add(i);
        }
        int count = 0;

        while (!minHeap.isEmpty() && additionalRocks > 0) {
            int curr = minHeap.poll();
            int diff = capacity[curr] - rocks[curr];
            if (diff <= additionalRocks) {
                additionalRocks -= diff;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityofRocks mbwfcr = new MaximumBagsWithFullCapacityofRocks();
        int[] capacity = new int[]{2, 3, 4, 5};
        int[] rocks = new int[]{1, 2, 4, 4};
        System.out.println(mbwfcr.maximumBags(capacity, rocks, 2));
    }
}
