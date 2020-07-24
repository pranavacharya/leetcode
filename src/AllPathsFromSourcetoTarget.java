
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllPathsFromSourcetoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < graph.length; i++) {
            adj.put(i, new ArrayList());
        }
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> list = new ArrayList();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.put(i, list);
        }
        ArrayList<Integer> path = new ArrayList();
        path.add(0);
        dfs(result, adj, path, 0, graph.length - 1);
        return result;
    }

    public void dfs(List<List<Integer>> result, HashMap<Integer, ArrayList<Integer>> adj,
            ArrayList<Integer> path, int node, int destination) {
        if (node == destination) {
            result.add(new ArrayList(path));
        } else {
            ArrayList<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                path.add(neighbour);
                dfs(result, adj, path, neighbour, destination);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        AllPathsFromSourcetoTarget apfst = new AllPathsFromSourcetoTarget();
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(apfst.allPathsSourceTarget(graph));
    }
}
