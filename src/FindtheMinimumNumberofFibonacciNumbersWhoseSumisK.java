
import java.util.ArrayList;
import java.util.Arrays;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumisK {

    private int min = Integer.MAX_VALUE;

    public int findMinFibonacciNumbers(int k) {
        System.out.println(Arrays.toString(fibonacciNumbers(k)));
        int[] fibo = fibonacciNumbers(k);
        combination(fibo, 0, 0, new ArrayList<>(), k);
        return this.min;
    }

    public void combination(int[] candidates, int pos, int sum, ArrayList paths, int target) {
        if (sum == target) {
            min = Math.min(min, paths.size());
        } else if (sum > target) {
            return;
        } else if (candidates.length == pos) {
            return;
        } else {
            paths.add(candidates[pos]);
            combination(candidates, pos + 1, sum + candidates[pos], new ArrayList(paths), target);
            paths.remove(paths.size() - 1);
            combination(candidates, pos + 1, sum, new ArrayList(paths), target);
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
