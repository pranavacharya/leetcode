
import java.util.HashMap;

public class FibonacciNumber {

    private HashMap<Integer, Integer> map = new HashMap();

    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        if (map.containsKey(N)) {
            return map.get(N);
        } else {
            int ans = fib(N - 2) + fib(N - 1);
            map.put(N, ans);
            return ans;
        }
    }

    public static void main(String args[]) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fib(4));
    }
}
