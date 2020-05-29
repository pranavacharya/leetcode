
import java.util.ArrayList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }
        for (int[] pre : prerequisites) {
            ArrayList<Integer> temp = adj.get(pre[0]);
            temp.add(pre[1]);
        }
        for (int i = 0; i < adj.size(); i++) {
            if (!adj.get(i).isEmpty()) {
                if (!dfs(adj, i, new ArrayList())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int index, ArrayList<Integer> path) {
        if (path.contains(index)) {
            return false;
        } else if (adj.get(index).isEmpty()) {
            return true;
        } else {
            ArrayList<Integer> options = adj.get(index);
            for (int i : options) {
                path.add(index);
                if (!dfs(adj, i, path)) {
                    return false;
                }
                path.remove(path.size() - 1);
            }
            return true;
        }
    }

    public static void main(String args[]) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(cs.canFinish(4, prerequisites));
    }
}
