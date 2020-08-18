
import java.util.ArrayList;
import java.util.Arrays;

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList<Integer> result = new ArrayList();
        if (N == 1) {
            result.add(0);
        }
        for (int i = 1; i <= 9; i++) {
            dfs(result, N - 1, i, K);
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public void dfs(ArrayList<Integer> result, int N, int number, int k) {
        if (N == 0) {
            result.add(number);
            return;
        }
        ArrayList<Integer> next = new ArrayList();
        int lastDigit = number % 10;
        next.add(lastDigit + k);
        if (k != 0) {
            next.add(lastDigit - k);
        }
        for (int i = 0; i < next.size(); i++) {
            int candidate = next.get(i);
            if (candidate >= 0 && candidate <= 9) {
                dfs(result, N - 1, number * 10 + candidate, k);
            }
        }
    }

    public static void main(String args[]) {
        NumbersWithSameConsecutiveDifferences nwscd = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(nwscd.numsSameConsecDiff(2, 0)));
    }
}
