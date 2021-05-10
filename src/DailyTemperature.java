
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String args[]) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dt = new DailyTemperature();
        System.out.println(Arrays.toString(dt.dailyTemperatures(input)));
    }

}
