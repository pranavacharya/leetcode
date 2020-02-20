
import java.util.Arrays;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ind = new int[10000];
        int[] max = new int[nums2.length];
        int pointer = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            ind[nums1[i]] = i + 1;
        }
        
        int[] res = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (pointer > 0 && max[pointer - 1] < num) {
                pointer--;
            }
            if (ind[num] > 0) {
                res[ind[num] - 1] = pointer == 0 ? -1 : max[pointer - 1];
            }
            max[pointer++] = num;
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
