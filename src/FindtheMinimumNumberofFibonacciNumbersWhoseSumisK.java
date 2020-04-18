
import java.util.ArrayList;
import java.util.Arrays;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumisK {

    public int findMinFibonacciNumbers(int k) {
        System.out.println(Arrays.toString(fibonacciNumbers(k)));
        int[] fibo = fibonacciNumbers(k);
        int min = greedy(fibo, k);
        return min;
    }

    public int greedy(int[] nums, int target) {
        int min = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target >= nums[i]) {
                min++;
                target -= nums[i];
            }
        }
        return min;
    }

    public int[] fibonacciNumbers(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 1;
        int b = 1;
        list.add(a);
        list.add(b);
        while (a + b <= k) {
            list.add(a + b);
            int temp = b;
            b = a + b;
            a = temp;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        FindtheMinimumNumberofFibonacciNumbersWhoseSumisK fmfs = new FindtheMinimumNumberofFibonacciNumbersWhoseSumisK();
        System.out.println(fmfs.findMinFibonacciNumbers(19));
        System.out.println(fmfs.findMinFibonacciNumbers(374602));
    }
}
