
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (!((c == ')' && top == '(') || (c == '}' && top == '{')
                            || (c == ']' && top == '['))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{[]}"));
    }
}
