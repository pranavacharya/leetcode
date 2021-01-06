
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
            } else {
                if (stack.peek() == S.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        RemoveAllAdjacentDuplicatesInString raads = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(raads.removeDuplicates("abbaca"));
    }
}
