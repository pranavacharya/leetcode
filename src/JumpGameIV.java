
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIV {

    public int minJumps(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            adj.put(i, new ArrayList());
        }
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                adj.get(i).add(i + 1);
            }
            if (i - 1 >= 0) {
                adj.get(i).add(i - 1);
            }
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    adj.get(i).add(j);
                }
            }
        }
        HashSet<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.poll();
                if (curr == arr.length - 1) {
                    return steps;
                }
                ArrayList<Integer> neighbours = adj.get(curr);
                for (int i = 0; i < neighbours.size(); i++) {
                    if (!visited.contains(neighbours.get(i))) {
                        queue.add(neighbours.get(i));
                        visited.add(neighbours.get(i));
                    }
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
