
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationstoConvertNumber {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{start, 0});
        HashSet<Integer> visited = new HashSet();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == goal) {
                return curr[1];
            }
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            for (int i = 0; i < nums.length; i++) {
                int plus = curr[0] + nums[i];
                int minus = curr[0] - nums[i];
                int or = curr[0] ^ nums[i];

                if (plus == goal || minus == goal || or == goal) {
                    return curr[1] + 1;
                }

                if (plus >= 0 && plus <= 1000 && !visited.contains(plus)) {
                    queue.add(new int[]{plus, curr[1] + 1});
                }
                if (minus >= 0 && minus <= 1000 && !visited.contains(minus)) {
                    queue.add(new int[]{minus, curr[1] + 1});
                }
                if (or >= 0 && or <= 1000 && !visited.contains(or)) {
                    queue.add(new int[]{or, curr[1] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumOperationstoConvertNumber mocn = new MinimumOperationstoConvertNumber();
        int[] nums = new int[]{1, 3};
        System.out.println(mocn.minimumOperations(nums, 6, 4));
    }
}
