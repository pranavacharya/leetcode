
import java.util.ArrayList;
import java.util.Arrays;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumisK {

    private int min = Integer.MAX_VALUE;

    public int findMinFibonacciNumbers(int k) {
        System.out.println(Arrays.toString(fibonacciNumbers(k)));
        int[] fibo = fibonacciNumbers(k);
        combination(new ArrayList<>(), fibo, k, 0);
        return this.min;
    }

    public void combination(ArrayList<Integer> path, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            this.min = Math.min(this.min, path.size());
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            combination(path, nums, remain - nums[i], i + 1);
            path.remove(path.size() - 1);
        }
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
    }
}
