
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            for (int j = map[nums1[i]] + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        NextGreaterElement1 nge1 = new NextGreaterElement1();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nge1.nextGreaterElement(nums1, nums2)));
    }
}
