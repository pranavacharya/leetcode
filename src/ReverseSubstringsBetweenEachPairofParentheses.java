
import java.util.ArrayList;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ')') {
                stack.push(s.charAt(i));
                i++;
            }
            if (i < s.length() && s.charAt(i) == ')') {
                ArrayList<Character> list = new ArrayList();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    list.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                stack.addAll(list);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        ReverseSubstringsBetweenEachPairofParentheses rsbepop = new ReverseSubstringsBetweenEachPairofParentheses();
        System.out.println(rsbepop.reverseParentheses("(abcd)"));
        System.out.println(rsbepop.reverseParentheses("(u(love)i)"));
        System.out.println(rsbepop.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(rsbepop.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
