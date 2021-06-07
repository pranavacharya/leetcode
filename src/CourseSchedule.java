
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int start = pre[1];
            int end = pre[0];
            adj.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> sorted = new ArrayList();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sorted.add(curr);
            ArrayList<Integer> preq = adj.get(curr);
            for (int i = 0; i < preq.size(); i++) {
                indegree[preq.get(i)]--;
                if (indegree[preq.get(i)] == 0) {
                    queue.add(preq.get(i));
                }
            }
        }
        return sorted.size() == numCourses;
    }

    public static void main(String args[]) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(cs.canFinish(4, prerequisites));
    }
}
