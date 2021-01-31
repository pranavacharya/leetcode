
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RestoretheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        int[] ans = new int[adjacentPairs.length + 1];
        for (int i = 0; i < adjacentPairs.length; i++) {
            int first = adjacentPairs[i][0];
            int second = adjacentPairs[i][1];
            adj.putIfAbsent(first, new ArrayList());
            adj.putIfAbsent(second, new ArrayList());
            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        for (int key : adj.keySet()) {
            if (adj.get(key).size() == 1) {
                ArrayList<Integer> list = new ArrayList();
                dfs(adj, list, key, new HashSet());
                for (int j = 0; j < list.size(); j++) {
                    ans[j] = list.get(j);
                }
                return ans;
            }
        }

        return ans;
    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> adj, ArrayList<Integer> result, int root, HashSet<Integer> visited) {
        result.add(root);
        visited.add(root);
        ArrayList<Integer> neighbours = adj.get(root);
        for (int i = 0; i < neighbours.size(); i++) {
            if (!visited.contains(neighbours.get(i))) {
                dfs(adj, result, neighbours.get(i), visited);
            }
        }
    }

    public static void main(String args[]) {
        RestoretheArrayFromAdjacentPairs rtfap = new RestoretheArrayFromAdjacentPairs();
        int[][] adjacentPairs = new int[][]{{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(rtfap.restoreArray(adjacentPairs)));
    }
}
