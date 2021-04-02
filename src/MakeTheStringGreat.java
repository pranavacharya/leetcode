
import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (Character.isLowerCase(c) && Character.isUpperCase(stack.peek())
                        && Character.toLowerCase(stack.peek()) == c) {
                    stack.pop();
                } else if (Character.isUpperCase(c) && Character.isLowerCase(stack.peek())
                        && Character.toUpperCase(stack.peek()) == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MakeTheStringGreat mtsg = new MakeTheStringGreat();
        System.out.println(mtsg.makeGood("leEeetcode"));
    }
}
