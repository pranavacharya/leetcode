
import java.util.HashMap;

public class MinimumDegreeofaConnectedTrioinaGraph {

    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] isEdge = new boolean[n + 1][n + 1];
        HashMap<Integer, Integer> inDegree = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            inDegree.put(edges[i][0], inDegree.getOrDefault(edges[i][0], 0) + 1);
            inDegree.put(edges[i][1], inDegree.getOrDefault(edges[i][1], 0) + 1);
            isEdge[edges[i][0]][edges[i][1]] = true;
            isEdge[edges[i][1]][edges[i][0]] = true;
        }
        int min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            for (int i = 0; i < n; i++) {
                if (isEdge[i][edge[0]] && isEdge[i][edge[1]]) {
                    int a = inDegree.get(i);
                    int b = inDegree.get(edge[0]);
                    int c = inDegree.get(edge[1]);
                    min = Math.min(min, a + b + c - 6);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String args[]) {
        MinimumDegreeofaConnectedTrioinaGraph mdoctig
                = new MinimumDegreeofaConnectedTrioinaGraph();
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
        System.out.println(mdoctig.minTrioDegree(6, edges));

    }
}
