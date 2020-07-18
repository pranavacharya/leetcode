
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            ArrayList<Integer> list = adj.get(edge[1]);
            list.add(edge[0]);
            adj.put(edge[1], list);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList();
        int nodesDone = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            nodesDone++;
            ArrayList<Integer> neighbours = adj.get(curr);
            for (int neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return nodesDone == numCourses ? ans : new int[]{};
    }

    public static void main(String args[]) {
        CourseScheduleII cs = new CourseScheduleII();
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(cs.findOrder(4, prerequisites)));
    }
}
