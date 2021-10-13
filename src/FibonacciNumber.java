
import java.util.Arrays;

public class FibonacciNumber {

    int[] memo;

    public int fib(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (this.memo[n] != -1) {
            return this.memo[n];
        }
        if (n <= 1) {
            return n;
        } else {
            return this.memo[n] = (helper(n - 1) + helper(n - 2));
        }
    }

    public static void main(String args[]) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fib(4));
    }
}
