
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[nodes];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && !biparte(graph, colors, 1, new boolean[nodes], i)) {
                return false;
            }
        }
        return true;
    }

    private boolean biparte(int[][] graph, int[] colors, int color, boolean[] visited, int node) {
        if (visited[node]) {
            if (colors[node] != color) {
                return false;
            }
        } else {
            colors[node] = color;
            visited[node] = true;
            for (int neighbour : graph[node]) {
                if (!biparte(graph, colors, -1 * color, visited, neighbour)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        IsGraphBipartite igb = new IsGraphBipartite();
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(igb.isBipartite(graph));
    }
}
