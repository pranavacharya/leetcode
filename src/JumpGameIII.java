
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (arr[curr] == 0) {
                return true;
            }
            visited.add(curr);
            if (curr + arr[curr] < arr.length && curr + arr[curr] >= 0 && !visited.contains(curr + arr[curr])) {
                queue.add(curr + arr[curr]);
            }
            if (curr - arr[curr] < arr.length && curr - arr[curr] >= 0 && !visited.contains(curr - arr[curr])) {
                queue.add(curr - arr[curr]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        JumpGameIII jg = new JumpGameIII();
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        System.out.println(jg.canReach(arr, 5));
    }
}
