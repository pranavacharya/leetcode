
import java.util.Stack;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        int open = 0;
        int close = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                open++;
            } else {
                stack.push(c);
                close++;
            }
            if (open == close) {
                sb.append(removeOuter(stack));
                open = 0;
                close = 0;
            }
        }
        return sb.toString();
    }

    public String removeOuter(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        stack.pop();
        while (stack.size() > 1) {
            char c = stack.pop();
            sb.append(c);
        }
        stack.pop();
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        RemoveOutermostParentheses romp = new RemoveOutermostParentheses();
        System.out.println(romp.removeOuterParentheses("(()())(())"));
        System.out.println(romp.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(romp.removeOuterParentheses("()()"));
    }
}
