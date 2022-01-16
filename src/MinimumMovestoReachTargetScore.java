
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovestoReachTargetScore {

    public int minMoves(int target, int maxDoubles) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{1, maxDoubles});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] item = queue.poll();
                int curr = item[0];
                int dob = item[1];
                if (curr == target) {
                    return steps;
                }

                queue.add(new int[]{curr + 1, dob});
                if (dob > 0 && curr * 2 <= target) {
                    queue.add(new int[]{curr * 2, dob - 1});
                }
                size--;
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        MinimumMovestoReachTargetScore mmrts = new MinimumMovestoReachTargetScore();
        System.out.println(mmrts.minMoves(10000, 4));
    }
}
