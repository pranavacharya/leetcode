
import java.util.Arrays;
import java.util.PriorityQueue;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        int j = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        for (int i = j; i >= 0; i = i - 2) {
            nums[i] = minHeap.poll();
        }
        j = nums.length % 2 == 0 ? nums.length - 1 : nums.length - 2;
        for (int i = j; i >= 0; i = i - 2) {
            nums[i] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        WiggleSortII ws2 = new WiggleSortII();
        int[] nums = new int[]{1, 3, 2, 2, 3, 1};
        ws2.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
