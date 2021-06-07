
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] pre : prerequisites) {
            int start = pre[1];
            int end = pre[0];
            adj.get(start).add(end);
        }
        boolean[] isVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && !dfs(adj, i, isVisited, new HashSet())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(HashMap<Integer, ArrayList<Integer>> adj, int root,
            boolean[] isVisited, HashSet<Integer> path) {
        if (path.contains(root)) {
            return false;
        }
        if (isVisited[root]) {
            return true;
        }
        path.add(root);
        isVisited[root] = true;
        ArrayList<Integer> preq = adj.get(root);
        for (int i = 0; i < preq.size(); i++) {
            if (!dfs(adj, preq.get(i), isVisited, path)) {
                return false;
            }
        }
        path.remove(root);
        return true;
    }

    public static void main(String args[]) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(cs.canFinish(4, prerequisites));
    }
}
