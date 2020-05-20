
import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<int[]> stack = new Stack();
        for (String operation : ops) {
            if (operation.equals("C") && !stack.isEmpty()) {
                stack.pop();
            } else if (operation.equals("D")) {
                if (!stack.isEmpty()) {
                    int point = stack.peek()[0] * 2;
                    int sum = stack.peek()[1] + point;
                    stack.add(new int[]{point, sum});
                }
            } else if (operation.equals("+")) {
                int point;
                int[] last = new int[]{0, 0};
                int[] secondLast = new int[]{0, 0};
                if (!stack.isEmpty()) {
                    last = stack.pop();
                    if (!stack.isEmpty()) {
                        secondLast = stack.pop();
                        stack.push(secondLast);
                    }
                    stack.push(last);
                }
                point = last[0] + secondLast[0];
                int sum = point;
                if (!stack.isEmpty()) {
                    sum += stack.peek()[1];
                }
                stack.push(new int[]{point, sum});
            } else {
                int point = Integer.parseInt(operation);
                int sum = point;
                if (!stack.isEmpty()) {
                    sum += stack.peek()[1];
                }
                stack.add(new int[]{point, sum});
            }
        }
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        BaseballGame bg = new BaseballGame();
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        String[] ops1 = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(bg.calPoints(ops));
        System.out.println(bg.calPoints(ops1));
    }
}
