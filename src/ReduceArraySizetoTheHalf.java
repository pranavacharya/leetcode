
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReduceArraySizetoTheHalf {

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int key : freq.keySet()) {
            maxHeap.add(freq.get(key));
        }
        int initSize = maxHeap.size();
        int reqSize = arr.length / 2;
        while (!maxHeap.isEmpty()) {
            reqSize -= maxHeap.poll();
            if (reqSize <= 0) {
                return initSize - maxHeap.size();
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        ReduceArraySizetoTheHalf rash = new ReduceArraySizetoTheHalf();
        int[] arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(rash.minSetSize(arr));
    }
}
