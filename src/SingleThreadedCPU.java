
import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Integer> incommingQueue = new PriorityQueue<>((a, b) -> (tasks[a][0] - tasks[b][0]));
        for (int i = 0; i < tasks.length; i++) {
            incommingQueue.add(i);
        }
        PriorityQueue<Integer> processQueue = new PriorityQueue<>((a, b) -> (tasks[a][1] == tasks[b][1] ? a - b : tasks[a][1] - tasks[b][1]));
        int[] ans = new int[tasks.length];
        int index = 0;

        //initialize
        int startTime = tasks[incommingQueue.peek()][0];
        while (!incommingQueue.isEmpty() && tasks[incommingQueue.peek()][0] == startTime) {
            processQueue.add(incommingQueue.poll());
        }
        int curr = processQueue.poll();
        int currEnd = tasks[curr][0] + tasks[curr][1];

        while (index < ans.length) {
            // add process into queue
            while (!incommingQueue.isEmpty() && tasks[incommingQueue.peek()][0] <= currEnd) {
                processQueue.add(incommingQueue.poll());
            }

            // process ending
            ans[index++] = curr;

            // process task from queue
            if (!processQueue.isEmpty()) {
                curr = processQueue.poll();
                currEnd += tasks[curr][1];
            }

            if (!incommingQueue.isEmpty() && processQueue.isEmpty() && tasks[incommingQueue.peek()][0] > currEnd) {
                int nextTime = tasks[incommingQueue.peek()][0];
                while (!incommingQueue.isEmpty() && tasks[incommingQueue.peek()][0] == nextTime) {
                    processQueue.add(incommingQueue.poll());
                }
                curr = processQueue.poll();
                currEnd = tasks[curr][0] + tasks[curr][1];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        SingleThreadedCPU stc = new SingleThreadedCPU();
//        int[][] tasks = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[][] tasks = new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
//        int[][] tasks = new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
//        int[][] tasks = new int[][]{{100, 100}, {1000000000, 1000000000}};
        System.out.println(Arrays.toString(stc.getOrder(tasks)));
    }
}
