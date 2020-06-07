
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ThekStrongestValuesinanArray {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Math.abs(arr[a] - median) == Math.abs(arr[b] - median)
                ? arr[a] - arr[b] : Math.abs(arr[a] - median) - Math.abs(arr[b] - median));

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        ArrayList<Integer> result = new ArrayList();
        while (!minHeap.isEmpty()) {
            int index = minHeap.poll();
            result.add(arr[index]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        ThekStrongestValuesinanArray tksva = new ThekStrongestValuesinanArray();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(tksva.getStrongest(arr, 2)));
    }
}
