
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReductionOperationstoMaketheArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (nums[b] != nums[a]
                ? nums[b] - nums[a] : a - b));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(i);
        }
        int count = 0;
        while (!maxHeap.isEmpty()) {
            int index = maxHeap.poll();
            ArrayList<Integer> temp = new ArrayList();
            while (!maxHeap.isEmpty() && nums[maxHeap.peek()] == nums[index]) {
                temp.add(maxHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                return count;
            }
            nums[index] = nums[maxHeap.peek()];
            maxHeap.add(index);
            maxHeap.addAll(temp);
            count++;
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
