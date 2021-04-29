
import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else if (c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MinimumAddtoMakeParenthesesValid mampv = new MinimumAddtoMakeParenthesesValid();
        System.out.println(mampv.minAddToMakeValid("())"));
        System.out.println(mampv.minAddToMakeValid("((("));
        System.out.println(mampv.minAddToMakeValid("()"));
        System.out.println(mampv.minAddToMakeValid("()))(("));
    }
}
