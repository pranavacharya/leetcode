
import java.util.ArrayList;
import java.util.HashMap;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] road : roads) {
            indegree[road[0]]++;
            indegree[road[1]]++;
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> neighbours = adj.get(i);
            for (int j = i + 1; j < n; j++) {
                int local = indegree[i] + indegree[j];
                if (neighbours.contains(j)) {
                    local--;
                }
                max = Math.max(max, local);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximalNetworkRank mnr = new MaximalNetworkRank();
        int[][] roads = new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(mnr.maximalNetworkRank(4, roads));
    }
}
