
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];

        for (int i = 0; i < colour.length; i++) {
            if (colour[i] == 0 && !dfs(graph, colour, 1, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int[] colour, int currentColour, int node) {
        if (colour[node] != 0) {
            return colour[node] == currentColour;
        } else {
            colour[node] = currentColour;
            for (int nei : graph[node]) {
                if (!dfs(graph, colour, -currentColour, nei)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        IsGraphBipartite igb = new IsGraphBipartite();
//        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(igb.isBipartite(graph));
    }
}
