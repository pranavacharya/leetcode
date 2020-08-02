
import java.util.HashMap;
import java.util.Stack;

public class GettheMaximumScore {

    private long mod = 1000000007;

    public class State {

        int arr;
        int index;
        int sum;

        public State(int arr, int index, int sum) {
            this.arr = arr;
            this.index = index;
            this.sum = sum;
        }
    }

    public int maxSum(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> oneMap = new HashMap();
        HashMap<Integer, Integer> twoMap = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            oneMap.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            twoMap.put(nums2[i], i);
        }

        Stack<State> stack = new Stack();
        int max = 0;
        stack.push(new State(1, 0, 0));
        stack.push(new State(2, 0, 0));
        while (!stack.isEmpty()) {
            State curr = stack.pop();
            int arrno = curr.arr;
            int index = curr.index;
            int sum = curr.sum;
            if (arrno == 1) { //nums1
                while (index < nums1.length) {
                    sum = (int) (((sum % mod) + (nums1[index] % mod)) % mod);
                    if (twoMap.containsKey(nums1[index])) {
                        stack.push(new State(2, twoMap.get(nums1[index]) + 1, sum));
                    }
                    index++;
                }
                max = Math.max(max, sum);
            } else { //nums2
                while (index < nums2.length) {
                    sum = (int) (((sum % mod) + (nums2[index] % mod)) % mod);
                    if (oneMap.containsKey(nums2[index])) {
                        stack.push(new State(1, oneMap.get(nums2[index]) + 1, sum));
                    }
                    index++;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        GettheMaximumScore gms = new GettheMaximumScore();
        int[] nums1 = new int[]{1, 3, 5, 7, 9};
        int[] nums2 = new int[]{3, 5, 100};
        System.out.println(gms.maxSum(nums1, nums2));
    }
}
