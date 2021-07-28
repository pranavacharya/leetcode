
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return helper(N);
    }

    public int[] helper(int N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : helper((N + 1) / 2)) // odds
            {
                ans[t++] = 2 * x - 1;
            }
            for (int x : helper(N / 2)) // evens
            {
                ans[t++] = 2 * x;
            }
        }
        memo.put(N, ans);
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArray ba = new BeautifulArray();
        System.out.println(Arrays.toString(ba.beautifulArray(4)));
    }
}
