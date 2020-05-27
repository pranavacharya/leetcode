
import java.util.Arrays;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] adj = new int[N][N];
        for (int[] i : dislikes) {
            adj[i[0] - 1][i[1] - 1] = 1;
            adj[i[1] - 1][i[0] - 1] = 1;
        }
        int[] color = new int[N];
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0 && !dfs(adj, color, i, 1)) {
                return false;
            }
        }
        System.out.println(Arrays.deepToString(adj));
        return true;
    }

    public boolean dfs(int[][] adj, int[] color, int node, int cc) {
        if (color[node] != 0) {
            return color[node] == cc;
        } else {
            color[node] = cc;
            for (int i = 0; i < color.length; i++) {
                if (adj[node][i] == 1 && !dfs(adj, color, i, -cc)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        PossibleBipartition pb = new PossibleBipartition();
        int[][] dislikes = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(pb.possibleBipartition(5, dislikes));
    }
}
