
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (frequency.get(a) - frequency.get(b)));
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int key : frequency.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    public static void main(String args[]) {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(tkfe.topKFrequent(nums, 2)));
    }
}
