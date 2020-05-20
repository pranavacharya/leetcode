
import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for (String operation : ops) {
            if (operation.equals("C") && !stack.isEmpty()) {
                stack.pop();
            } else if (operation.equals("D")) {
                int point = stack.peek() * 2;
                stack.add(point);
            } else if (operation.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();
                stack.push(last);
                stack.push(last + secondLast);
            } else {
                int point = Integer.parseInt(operation);
                stack.push(point);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String args[]) {
        BaseballGame bg = new BaseballGame();
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        String[] ops1 = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(bg.calPoints(ops));
        System.out.println(bg.calPoints(ops1));
    }
}
