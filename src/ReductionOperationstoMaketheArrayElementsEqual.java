
import java.util.PriorityQueue;

public class ReductionOperationstoMaketheArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (nums[a] != nums[b]
                ? nums[a] - nums[b] : a - b));
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(i);
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            while (!minHeap.isEmpty() && nums[minHeap.peek()] == nums[min]) {
                minHeap.poll();
            }
            count += minHeap.size();
        }
        return count;
    }

    public static void main(String[] args) {
        ReductionOperationstoMaketheArrayElementsEqual romaee
                = new ReductionOperationstoMaketheArrayElementsEqual();
        int[] nums = new int[]{5, 1, 3};
        System.out.println(romaee.reductionOperations(nums));
    }
}
