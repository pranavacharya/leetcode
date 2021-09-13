
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        int[][] weight = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            weight[edges[i][0]][edges[i][1]] = edges[i][2];
            weight[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        queue.add(new int[]{0, maxMoves});

        int ans = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int movesLeft = curr[1];
            if (visited[node]) {
                continue;
            }
            ans++;
            visited[node] = true;
            ArrayList<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {

                if (!visited[neighbour] && weight[node][neighbour] + 1 <= movesLeft) {
                    queue.add(new int[]{neighbour, movesLeft - weight[node][neighbour] - 1});
                }
                int cost = Math.min(movesLeft, weight[node][neighbour]);
                weight[node][neighbour] -= cost;
                weight[neighbour][node] -= cost;

                ans += cost;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ReachableNodesInSubdividedGraph rnsg = new ReachableNodesInSubdividedGraph();
        Scanner sc = new Scanner(System.in);
        int[][] edges = new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        System.out.println(rnsg.reachableNodes(edges, 6, 3));
    }
}
