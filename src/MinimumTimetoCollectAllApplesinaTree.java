
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumTimetoCollectAllApplesinaTree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int minTime;
        minTime = dfs(adj, hasApple, visited, 0);
        return minTime;
    }

    public int dfs(HashMap<Integer, ArrayList<Integer>> adj, List<Boolean> hasApple, boolean[] visited, int node) {
        visited[node] = true;
        int distance = 0;
        ArrayList<Integer> neighbours = adj.get(node);
        for (int neighbour : neighbours) {
            if (visited[neighbour]) {
                continue;
            }
            distance += dfs(adj, hasApple, visited, neighbour);
        }
        if (distance == 0 && hasApple.get(node) && node != 0) {
            distance += 2;
        } else if (distance > 0 && node != 0) {
            distance += 2;
        }
        return distance;
    }

    public static void main(String args[]) {
        MinimumTimetoCollectAllApplesinaTree mtcait = new MinimumTimetoCollectAllApplesinaTree();
        List<Boolean> hasApple = new ArrayList();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        System.out.println(mtcait.minTime(7, edges, hasApple));
    }
}
