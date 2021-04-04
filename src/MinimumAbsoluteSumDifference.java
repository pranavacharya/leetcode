
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimumAbsoluteSumDifference {

    private int mod = (int) (1e9 + 7);

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)
                -> (Double.compare(Math.abs(nums1[b] - nums2[b]), Math.abs(nums1[a] - nums2[a]))));
        TreeMap<Integer, Integer> nums1Tree = new TreeMap();

        for (int i = 0; i < nums1.length; i++) {
            sum = (sum % mod + Math.abs(nums1[i] - nums2[i]) % mod) % mod;
            maxHeap.add(i);
            nums1Tree.put(nums1[i], 0);
        }

        if (sum == 0) {
            return sum;
        }

        int absDiff = 0;
        int i = -1;
        while (!maxHeap.isEmpty()) {
            int index = maxHeap.poll();
            int higher = nums1Tree.ceilingKey(nums2[index]) == null ? Integer.MAX_VALUE : nums1Tree.ceilingKey(nums2[index]);
            int lower = nums1Tree.floorKey(nums2[index]) == null ? Integer.MIN_VALUE : nums1Tree.floorKey(nums2[index]);
            int local = Math.min(Math.abs(higher - nums2[index]),
                    Math.abs(lower - nums2[index])
            );

            int diff = Math.abs(local - Math.abs(nums1[index] - nums2[index]));
            if (absDiff < diff) {
                absDiff = diff;
                i = index;
            }
        }

        if (i == -1) {
            return sum;
        }

        return sum - absDiff;
    }

    public static void main(String[] args) {
        MinimumAbsoluteSumDifference masd = new MinimumAbsoluteSumDifference();
        int[] nums1 = new int[]{1, 10, 4, 4, 2, 7};
        int[] nums2 = new int[]{9, 3, 5, 1, 7, 4};
        System.out.println(masd.minAbsoluteSumDiff(nums1, nums2));
    }
}
