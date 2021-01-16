
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for (int i = 0; i < nums.length; i++) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return nums[queue.poll()];
    }

    public static void main(String args[]) {
        KthLargestElementinanArray klea = new KthLargestElementinanArray();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(klea.findKthLargest(nums, 2));
    }
}
