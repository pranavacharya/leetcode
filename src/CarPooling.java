
import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Arrays.sort(trips, (a, b) -> Double.compare(a[1], b[1]));
        for (int i = 0; i < trips.length; i++) {
            int[] curr = trips[i];
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= curr[1]) {
                capacity += minHeap.peek()[1];
                minHeap.poll();
            }
            capacity -= curr[0];
            if (capacity < 0) {
                return false;
            }
            minHeap.add(new int[]{curr[2], curr[0]});
        }
        return true;
    }

    public static void main(String args[]) {
        CarPooling cp = new CarPooling();
        int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println(cp.carPooling(trips, 11));
    }
}
