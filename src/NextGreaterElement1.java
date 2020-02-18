
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            }
            stack.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                ans[i] = map.get(nums1[i]);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        NextGreaterElement1 nge1 = new NextGreaterElement1();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nge1.nextGreaterElement(nums1, nums2)));
    }
}
