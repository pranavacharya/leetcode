
import java.util.HashMap;

public class MinimumNumberofRefuelingStops {

    private HashMap<Integer, Integer>[] dp;

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        this.dp = new HashMap[stations.length + 2];
        int[][] newStations = new int[stations.length + 1][2];
        for (int i = 0; i < this.dp.length; i++) {
            this.dp[i] = new HashMap();
        }
        newStations[0][1] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            newStations[i + 1][0] = stations[i][0];
            newStations[i + 1][1] = stations[i][1];
        }

        int ans = helper(newStations, target, 0, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[][] stations, int target, int index, int fuel) {

        int range = fuel + stations[index][1];

        int distCovered = stations[index][0];

        if (range >= target - distCovered) {
            return 0;
        }

        if (this.dp[index].containsKey(fuel)) {
            return this.dp[index].get(fuel);
        }

        int minStops = Integer.MAX_VALUE;

        for (int i = index + 1; i < stations.length; i++) {
            if (stations[i][0] > distCovered + range) {
                break;
            }

            minStops = Math.min(minStops, helper(stations, target, i, range - (stations[i][0] - distCovered)));

        }
        this.dp[index].put(fuel, minStops == Integer.MAX_VALUE ? minStops : minStops + 1);
        return minStops == Integer.MAX_VALUE ? minStops : minStops + 1;

    }

    public static void main(String[] args) {
        MinimumNumberofRefuelingStops mnrs = new MinimumNumberofRefuelingStops();
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(mnrs.minRefuelStops(100, 10, stations));
    }
}
