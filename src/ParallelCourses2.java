
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelCourses2 {

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i <= n; i++) {
            adj.put(i, new ArrayList());
        }
        int[] indegree = new int[n + 1];
        int[] maxLen = new int[n + 1];
        for (int[] edge : dependencies) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int minSem = 0;
        ArrayList<Integer> order = new ArrayList();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            ArrayList<Integer> neighbours = adj.get(curr);
            for (int neighbour : neighbours) {
                maxLen[neighbour] = Math.max(maxLen[neighbour], 1 + maxLen[curr]);
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        for (int i : maxLen) {
            minSem = Math.max(minSem, i);
        }
        return minSem + 1;
    }

    public static void main(String args[]) {
        ParallelCourses2 pc2 = new ParallelCourses2();
        int[][] depenencies = new int[][]{{2, 1}, {3, 1}, {4, 1}, {1, 5}};
        System.out.println(pc2.minNumberOfSemesters(5, depenencies, 2));
//        int[][] depenencies = new int[][]{{2, 1}, {3, 1}, {1, 4}};
//        System.out.println(pc2.minNumberOfSemesters(4, depenencies, 2));
//        int[][] depenencies = new int[][]{{1, 2}, {1, 3}, {7, 5}, {7, 6}, {4, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}};
//        System.out.println(pc2.minNumberOfSemesters(12, depenencies, 2));
    }
}
