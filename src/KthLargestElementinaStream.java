
import java.util.PriorityQueue;

public class KthLargestElementinaStream {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            this.minHeap.add(nums[i]);
            if (this.minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }

    public int add(int val) {
        this.minHeap.add(val);
        if (this.minHeap.size() > this.k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }

    public static void main(String args[]) {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargestElementinaStream kles = new KthLargestElementinaStream(3, nums);
        System.out.println(kles.add(3));
        System.out.println(kles.add(5));
        System.out.println(kles.add(10));
        System.out.println(kles.add(9));
        System.out.println(kles.add(4));
    }
}
