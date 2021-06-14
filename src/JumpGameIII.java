
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        boolean[] visited = new boolean[arr.length];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) {
                return true;
            }
            if (curr - arr[curr] >= 0 && curr - arr[curr] < arr.length && !visited[curr - arr[curr]]) {
                queue.add(curr - arr[curr]);
                visited[curr - arr[curr]] = true;
            }

            if (curr + arr[curr] >= 0 && curr + arr[curr] < arr.length && !visited[curr + arr[curr]]) {
                queue.add(curr + arr[curr]);
                visited[curr + arr[curr]] = true;
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
