
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i) && !result.contains(i)) {
                result.add(i);
            }
        }
        int[] res = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return res;
    }

    public static void main(String args[]) {
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(iota.intersection(nums1, nums2)));
    }
}
