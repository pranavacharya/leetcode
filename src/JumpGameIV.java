
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIV {

    public int minJumps(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            adj.put(arr[i], new ArrayList());
        }
        for (int i = 0; i < arr.length; i++) {
            adj.get(arr[i]).add(i);
        }
        HashSet<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited.add(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.poll();
                if (curr == arr.length - 1) {
                    return steps;
                }
                if (curr - 1 >= 0 && !visited.contains(curr - 1)) {
                    queue.add(curr - 1);
                    visited.add(curr - 1);
                }
                if (curr + 1 < arr.length && !visited.contains(curr + 1)) {
                    queue.add(curr + 1);
                    visited.add(curr + 1);
                }
                if (adj.containsKey(arr[curr])) {
                    for (int index : adj.get(arr[curr])) {
                        if (!visited.contains(index)) {
                            queue.add(index);
                        }
                    }
                    adj.remove(arr[curr]);
                }
                size--;
            }
            steps++;
        }
        return -1;
    }

    public static void main(String args[]) {
        JumpGameIV jg = new JumpGameIV();
        int[] arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(jg.minJumps(arr));
    }
}
