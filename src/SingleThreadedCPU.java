
import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Integer> incommingQueue = new PriorityQueue<>((a, b) -> (tasks[a][0] - tasks[b][0]));
        for (int i = 0; i < tasks.length; i++) {
            incommingQueue.add(i);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (tasks[a][1] == tasks[b][1] ? a - b : tasks[a][1] - tasks[b][1]));
        int[] ans = new int[tasks.length];
        int index = 0;
        int time = 1;
        int curr = -1;
        int currEnd = -1;
        while (time < (int) 1e9) {
            // process ending
            if (curr != -1 && currEnd == time) {
                ans[index++] = curr;
                curr = -1;
                currEnd = -1;
            }

            // add process
            while (!incommingQueue.isEmpty() && tasks[incommingQueue.peek()][0] == time) {
                queue.add(incommingQueue.poll());
            }

            // add process if not processing
            if (!queue.isEmpty() && curr == -1) {
                curr = queue.poll();
                currEnd = time + tasks[curr][1];
            }

            if (incommingQueue.isEmpty() && queue.isEmpty() && curr == -1) {
                break;
            }

            time++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleThreadedCPU stc = new SingleThreadedCPU();
//        int[][] tasks = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[][] tasks = new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
//        int[][] tasks = new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        System.out.println(Arrays.toString(stc.getOrder(tasks)));
    }
}
