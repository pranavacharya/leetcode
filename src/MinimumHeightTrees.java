
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class MinimumHeightTrees {

    private int max = 0;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
        for (int i = 0; i < n; i++) {
            this.max = 0;
            dfs(adj, new HashSet(), i, 0);
            int local = this.max;
            ArrayList<Integer> temp = map.getOrDefault(local, new ArrayList());
            temp.add(i);
            map.put(local, temp);
        }

        int shortest = map.firstKey();
        return map.get(shortest);
    }

    public void dfs(ArrayList<Integer>[] adj, HashSet<Integer> visited, int node, int depth) {
        visited.add(node);
        for (int nei : adj[node]) {
            if (visited.contains(nei)) {
                continue;
            }
            dfs(adj, visited, nei, depth + 1);
        }
        max = Math.max(max, depth);
    }

    public static void main(String args[]) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(mht.findMinHeightTrees(6, edges));
    }
}
