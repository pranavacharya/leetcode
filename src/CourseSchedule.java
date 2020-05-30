
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            ArrayList<Integer> list = adj.getOrDefault(pre[0], new ArrayList());
            list.add(pre[1]);
            adj.put(pre[0], list);
            indegree[pre[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            if (!adj.containsKey(current)) {
                continue;
            }
            for (int nei : adj.get(current)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String args[]) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(cs.canFinish(4, prerequisites));
    }
}
