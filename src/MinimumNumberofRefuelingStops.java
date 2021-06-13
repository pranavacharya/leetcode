
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxFuel = startFuel;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int stop = 0;
        int index = 0;
        while (index < stations.length) {
            if (stations[index][0] <= maxFuel) {
                queue.add(stations[index][1]);
                index++;
            } else {
                if (queue.isEmpty()) {
                    return -1;
                } else {
                    maxFuel += queue.poll();
                    stop++;
                }
            }
            if (maxFuel >= target) {
                return stop;
            }
        }
        while (maxFuel < target) {
            if (queue.isEmpty()) {
                return -1;
            } else {
                maxFuel += queue.poll();
                stop++;
            }
            if (maxFuel >= target) {
                return stop;
            }
        }
        return stop;
    }

    public static void main(String[] args) {
        MinimumNumberofRefuelingStops mnrs = new MinimumNumberofRefuelingStops();
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(mnrs.minRefuelStops(100, 10, stations));
    }
}
