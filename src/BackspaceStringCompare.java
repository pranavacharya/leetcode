
import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return formText(S).equals(formText(T));
    }

    public String formText(String S) {
        Stack<Character> stack = new Stack();
        for (char c : S.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (c != '#') {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
