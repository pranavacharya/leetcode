
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeastNumberofUniqueIntegersafterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> frequency = new HashMap();
        for (int i : arr) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> frequency.get(a) - frequency.get(b));
        queue.addAll(frequency.keySet());
        int count = 0;
        while (!queue.isEmpty() && k > 0) {
            int key = queue.poll();
            frequency.put(key, frequency.get(key) - 1);
            if (frequency.get(key) == 0) {
                frequency.remove(key);
            } else {
                queue.add(key);
            }
            k--;
        }
        count = frequency.size();
        return count;
    }

    public static void main(String args[]) {
        LeastNumberofUniqueIntegersafterKRemovals lnuiakr = new LeastNumberofUniqueIntegersafterKRemovals();
        int[] arr = new int[]{2, 1, 1, 3, 3, 3};
        System.out.println(lnuiakr.findLeastNumOfUniqueInts(arr, 3));
    }
}
