
import java.util.HashMap;

public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map1 = findSums(nums1, nums2);
        HashMap<Integer, Integer> map2 = findSums(nums3, nums4);
        for (int key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                count += (map1.get(key) * map2.get(-key));
            }
        }
        return count;
    }

    private HashMap<Integer, Integer> findSums(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        FourSumII fs = new FourSumII();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        System.out.println(fs.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
