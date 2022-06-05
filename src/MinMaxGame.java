
import java.util.LinkedList;
import java.util.Queue;

public class MinMaxGame {

    public int minMaxGame(int[] nums) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (queue.size() > 1) {
            int size = queue.size();
            int min = 1;
            while (size > 0) {
                int first = queue.poll();
                int second = queue.poll();
                if (min == 1) {
                    queue.add(Math.min(first, second));
                } else {
                    queue.add(Math.max(first, second));
                }
                min *= -1;
                size -= 2;
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        MinMaxGame mmg = new MinMaxGame();
        int[] nums = new int[]{1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(mmg.minMaxGame(nums));
    }
}
