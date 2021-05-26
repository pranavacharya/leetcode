
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededtoInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                continue;
            }
            adj.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{headID, 0});
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            maxTime = Math.max(maxTime, curr[1]);
            ArrayList<Integer> subordinates = adj.get(curr[0]);
            for (int i = 0; i < subordinates.size(); i++) {
                queue.add(new int[]{subordinates.get(i), curr[1] + informTime[curr[0]]});
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        TimeNeededtoInformAllEmployees tniae = new TimeNeededtoInformAllEmployees();
        int[] manager = new int[]{2, 2, -1, 2, 2, 2};
        int[] informTime = new int[]{0, 0, 1, 0, 0, 0};
        System.out.println(tniae.numOfMinutes(6, 2, manager, informTime));
    }
}
