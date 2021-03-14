
import java.util.PriorityQueue;

public class EqualSumArraysWithMinimumNumberofOperations {

    public int minOperations(int[] nums1, int[] nums2) {

        int min1 = nums1.length;
        int max1 = 6 * nums1.length;
        int min2 = nums2.length;
        int max2 = 6 * nums2.length;
        if (min1 > max2 || min2 > max1) {
            return -1;
        }
        int sum1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        int sum2 = 0;
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }

        if (sum1 == sum2) {
            return 0;
        } else if (sum1 > sum2) {
            return findMinOps(nums2, nums1, Math.abs(sum1 - sum2));
        } else {
            return findMinOps(nums1, nums2, Math.abs(sum1 - sum2));
        }
    }

    private int findMinOps(int[] min, int[] max, int diff) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < min.length; i++) {
            minHeap.add(min[i]);
        }
        for (int i = 0; i < max.length; i++) {
            maxHeap.add(max[i]);
        }
        int ops = 0;
        while (diff > 0 && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
            int minelement = minHeap.peek();
            int maxelement = maxHeap.peek();
            if ((maxelement - 1) > (6 - minelement)) {
                diff -= maxelement - 1;
                maxHeap.poll();
            } else {
                diff -= 6 - minelement;
                minHeap.poll();
            }
            ops++;
        }

        while (diff > 0 && !minHeap.isEmpty()) {
            int minelement = minHeap.peek();
            diff -= 6 - minelement;
            minHeap.poll();
            ops++;
        }

        while (diff > 0 && !maxHeap.isEmpty()) {
            int maxelement = maxHeap.peek();
            diff -= maxelement - 1;
            maxHeap.poll();
            ops++;
        }
        return ops;
    }

    public static void main(String[] args) {
        EqualSumArraysWithMinimumNumberofOperations esawmno
                = new EqualSumArraysWithMinimumNumberofOperations();
        int[] nums1 = new int[]{3, 3, 2, 4, 2, 6, 2};
        int[] nums2 = new int[]{6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1};
//        int[] nums1 = new int[]{5, 2, 1, 5, 2, 2, 2, 2, 4, 3, 3, 5};
//        int[] nums2 = new int[]{1, 4, 5, 5, 6, 3, 1, 3, 3};
        System.out.println(esawmno.minOperations(nums1, nums2));
    }
}
