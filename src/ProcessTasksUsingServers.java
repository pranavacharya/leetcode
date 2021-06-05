
import java.util.Arrays;
import java.util.PriorityQueue;

public class ProcessTasksUsingServers {

    class Servers {

        int index;
        int processEndTime;
        int weight;

        public Servers(int index, int processEndTime, int weight) {
            this.index = index;
            this.processEndTime = processEndTime;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];
        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> (servers[a] == servers[b]
                ? a - b : servers[a] - servers[b]));
        PriorityQueue<Servers> unavailable = new PriorityQueue<>((a, b) -> (a.processEndTime != b.processEndTime
                ? a.processEndTime - b.processEndTime : (a.weight != b.weight) ? a.weight - b.weight : a.index - b.index));
        for (int i = 0; i < servers.length; i++) {
            available.add(i);
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = i;
            while (!unavailable.isEmpty() && unavailable.peek().processEndTime <= time) {
                available.add(unavailable.poll().index);
            }
            if (available.isEmpty()) {
                Servers curr = unavailable.poll();
                ans[i] = curr.index;
                curr.processEndTime += tasks[i];
                unavailable.add(curr);
            } else {
                int curr = available.poll();
                ans[i] = curr;
                unavailable.add(new Servers(curr, time + tasks[i], servers[curr]));
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
