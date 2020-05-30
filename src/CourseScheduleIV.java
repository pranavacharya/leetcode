
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] links = new int[n][n];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int[] pre : prerequisites) {
            ArrayList<Integer> temp = adj.getOrDefault(pre[0], new ArrayList());
            temp.add(pre[1]);
            adj.put(pre[0], temp);
        }
        for (int i = 0; i < n; i++) {
            dfs(links, adj, i, new ArrayList());
        }
        List<Boolean> result = new ArrayList();
        for (int[] q : queries) {
            result.add(links[q[1]][q[0]] == 1);
        }
        return result;
    }

    private void dfs(int[][] links, HashMap<Integer, ArrayList<Integer>> adj, int node, ArrayList<Integer> path) {
        for (int i : path) {
            links[node][i] = 1;
        }
        if (!adj.containsKey(node)) {
            return;
        } else {
            ArrayList<Integer> neighbours = adj.get(node);
            for (int nei : neighbours) {
                path.add(node);
                dfs(links, adj, nei, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        CourseScheduleIV cs = new CourseScheduleIV();
        int[][] prerequisites = new int[][]{{1, 0}};
        int[][] queries = new int[][]{{0, 1}, {1, 0}};
        System.out.println(cs.checkIfPrerequisite(2, prerequisites, queries));
    }
}
