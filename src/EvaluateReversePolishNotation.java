
import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        HashSet<String> ops = new HashSet();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for (String token : tokens) {
            if (stack.isEmpty()) {
                stack.push(token);
            } else if (ops.contains(token)) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = 0;
                if (token.equals("+")) {
                    result = first + second;
                } else if (token.equals("-")) {
                    result = first - second;
                } else if (token.equals("*")) {
                    result = first * second;
                } else {
                    result = first / second;
                }
                stack.push("" + result);
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(erpn.evalRPN(tokens));
    }
}
