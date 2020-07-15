
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {

    public class pair {

        int vertex;
        double weight;

        pair(int v, double w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, ArrayList<pair>> adj = new HashMap();
        double[] distance = new double[n];
        distance[start] = 1;
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            ArrayList<pair> temp = adj.get(edges[i][0]);
            temp.add(new pair(edges[i][1], succProb[i]));
            adj.put(edges[i][0], temp);
            ArrayList<pair> temp2 = adj.get(edges[i][1]);
            temp2.add(new pair(edges[i][0], succProb[i]));
            adj.put(edges[i][1], temp2);
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(distance[b], distance[a]));
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            if (curr == end) {
                return distance[end];
            }
            ArrayList<pair> neighbours = adj.get(curr);
            for (pair neighbour : neighbours) {
                if (visited[neighbour.vertex]) {
                    continue;
                }
                if (distance[neighbour.vertex] < distance[curr] * neighbour.weight) {
                    distance[neighbour.vertex] = distance[curr] * neighbour.weight;
                }
                queue.add(neighbour.vertex);
            }
        }
        return distance[end];
    }

    public static void main(String args[]) {
        PathwithMaximumProbability pwmp = new PathwithMaximumProbability();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        System.out.println(pwmp.maxProbability(3, edges, succProb, 0, 2));
    }
}
