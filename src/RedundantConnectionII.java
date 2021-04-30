
import java.util.Arrays;
import java.util.HashMap;

public class RedundantConnectionII {

    private HashMap<Integer, Integer> map = new HashMap();

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] indegree = new int[edges.length + 1];
        int node2Edge = -1;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            if (indegree[v] > 1) {
                node2Edge = v;
            }
        }
        if (node2Edge == -1) {
            return findRedundantDirectedConnection1(edges, -1);
        } else {
            for (int i = edges.length - 1; i >= 0; i--) {
                if (edges[i][1] == node2Edge) {
                    int[] ans = findRedundantDirectedConnection1(edges, edges[i][0]);
                    if (ans[0] == -1) {
                        return edges[i];
                    }
                    this.map.clear();
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] findRedundantDirectedConnection1(int[][] edges, int skip) {
        for (int[] edge : edges) {
            if (edge[0] == skip) {
                continue;
            }
            int u = edge[0];
            int v = edge[1];
            if (find(u) == find(v)) {
                return edge;
            }
            union(u, v);
        }
        return new int[]{-1, -1};
    }

    private int find(int x) {
        int key = x;
        while (this.map.containsKey(key) && key != this.map.get(key)) {
            key = this.map.get(key);
        }
        this.map.put(x, key);
        return this.map.get(x);
    }

    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        this.map.put(yParent, xParent);
    }

    public static void main(String args[]) {
        RedundantConnectionII rc = new RedundantConnectionII();
        int[][] edges = new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        System.out.println(Arrays.toString(rc.findRedundantDirectedConnection(edges)));
    }
}
