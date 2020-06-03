
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        ArrayList<Integer> result = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            } else if (indegree[i] == 1) {
                queue.offer(i);
            }
        }
        if (result.size() > 0) {
            return result;
        }
        while (!queue.isEmpty()) {
            result = new ArrayList();
            int noOfLeaves = queue.size();
            for (int i = 0; i < noOfLeaves; i++) {
                int currentLeaf = queue.poll();
                result.add(currentLeaf);
                indegree[currentLeaf]--;
                for (int nei : adj[currentLeaf]) {
                    if (indegree[nei] == 0) {
                        continue;
                    }
                    indegree[nei]--;
                    if (indegree[nei] == 1) {
                        queue.offer(nei);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(mht.findMinHeightTrees(6, edges));
    }
}
