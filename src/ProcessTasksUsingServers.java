
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProcessTasksUsingServers {

    class Servers {

        int index;
        int processEndTime;

        public Servers(int index, int processEndTime) {
            this.index = index;
            this.processEndTime = processEndTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];
        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> (servers[a] == servers[b]
                ? a - b : servers[a] - servers[b]));
        PriorityQueue<Servers> unavailable = new PriorityQueue<>((a, b) -> (a.processEndTime == b.processEndTime
                ? a.index - b.index : a.processEndTime - b.processEndTime));
        for (int i = 0; i < servers.length; i++) {
            available.add(i);
        }
        int time = 0;
        Queue<Integer> taskQueue = new LinkedList();
        for (int i = 0; i < tasks.length; i++) {
            time = i;
            taskQueue.add(i);
            while (!unavailable.isEmpty() && unavailable.peek().processEndTime <= time) {
                available.add(unavailable.poll().index);
            }
            while (!available.isEmpty() && !taskQueue.isEmpty()) {
                int curr = available.poll();
                int taskTime = taskQueue.poll();
                ans[taskTime] = curr;
                unavailable.add(new Servers(curr, time + tasks[taskTime]));
            }
        }
        while (!taskQueue.isEmpty()) {
            time++;
            while (!unavailable.isEmpty() && unavailable.peek().processEndTime <= time) {
                available.add(unavailable.poll().index);
            }
            while (!available.isEmpty() && !taskQueue.isEmpty()) {
                int curr = available.poll();
                int taskTime = taskQueue.poll();
                ans[taskTime] = curr;
                unavailable.add(new Servers(curr, time + tasks[taskTime]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ProcessTasksUsingServers ptus = new ProcessTasksUsingServers();
        int[] servers = new int[]{3, 3, 2};
        int[] tasks = new int[]{1, 2, 3, 2, 1, 2};
        System.out.println(Arrays.toString(ptus.assignTasks(servers, tasks)));
    }
}
