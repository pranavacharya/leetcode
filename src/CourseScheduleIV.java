
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        HashSet<Integer>[] allpre = new HashSet[n];
        int[] indegree = new int[n];
        for (int[] pre : prerequisites) {
            ArrayList<Integer> temp = adj.getOrDefault(pre[0], new ArrayList());
            temp.add(pre[1]);
            adj.put(pre[0], temp);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList();
        ArrayList<Integer> sorted = new ArrayList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
            allpre[i] = new HashSet();
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sorted.add(current);
            if (!adj.containsKey(current)) {
                continue;
            }
            ArrayList<Integer> neighbours = adj.get(current);
            for (int nei : neighbours) {
                allpre[nei].add(current);
                allpre[nei].addAll(allpre[current]);
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        List<Boolean> result = new ArrayList();
        for (int[] q : queries) {
            result.add(allpre[q[1]].contains(q[0]));
        }
        return result;
    }

    public static void main(String args[]) {
        CourseScheduleIV cs = new CourseScheduleIV();
        int[][] prerequisites = new int[][]{{1, 0}};
        int[][] queries = new int[][]{{0, 1}, {1, 0}};
        System.out.println(cs.checkIfPrerequisite(2, prerequisites, queries));
    }
}
