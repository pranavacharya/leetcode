
import java.util.PriorityQueue;

public class MinimumInitialEnergytoFinishTasks {

    public int minimumEffort(int[][] tasks) {
        int minEnergy = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> ((tasks[b][1] - tasks[b][0]) - (tasks[a][1] - tasks[a][0])));
        for (int i = 0; i < tasks.length; i++) {
            queue.add(i);
            minEnergy += tasks[i][0];
        }
        int diff = 0;
        int initEnergy = minEnergy;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int[] curr = tasks[index];
            if (curr[1] > initEnergy) {
                diff += curr[1] - initEnergy;
                initEnergy = curr[1];
            }
            initEnergy -= curr[0];
        }
        return minEnergy + diff;
    }

    public static void main(String args[]) {
        MinimumInitialEnergytoFinishTasks mietft = new MinimumInitialEnergytoFinishTasks();
        int[][] tasks = new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};
        System.out.println(mietft.minimumEffort(tasks));
    }
}
