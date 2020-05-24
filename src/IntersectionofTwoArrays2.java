
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> one = new HashMap();
        HashMap<Integer, Integer> two = new HashMap();
        for (int num : nums1) {
            one.put(num, one.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            two.put(num, two.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList();
        for (int key : one.keySet()) {
            if (two.containsKey(key)) {
                int min = Math.min(one.get(key), two.get(key));
                for (int i = 0; i < min; i++) {
                    list.add(key);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        IntersectionofTwoArrays2 ita = new IntersectionofTwoArrays2();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(ita.intersect(nums1, nums2)));
    }
}
