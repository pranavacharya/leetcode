
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : prerequisites) {
            adj[e[1]].add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        ArrayList<Integer> sorted = new ArrayList();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            sorted.add(current);
            for (int nei : adj[current]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};
        }
        int[] result = new int[sorted.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sorted.get(i);
        }
        return result;
    }

    public static void main(String args[]) {
        CourseScheduleII cs = new CourseScheduleII();
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(cs.findOrder(4, prerequisites)));
    }
}
