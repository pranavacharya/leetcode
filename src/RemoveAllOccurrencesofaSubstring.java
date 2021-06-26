
import java.util.Stack;

public class RemoveAllOccurrencesofaSubstring {

    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            balance(part, stack);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private void balance(String s, Stack<Character> stack) {
        if (stack.size() < s.length()) {
            return;
        }
        Stack<Character> temp = new Stack();
        int len = s.length() - 1;
        boolean flag = true;
        while (len >= 0) {
            char c = stack.pop();
            temp.add(c);
            if (s.charAt(len) == c) {
                len--;
            } else {
                flag = false;
                break;
            }
        }
        if (!flag) {
            while (!temp.isEmpty()) {
                stack.add(temp.pop());
            }
        }
    }

    public static void main(String[] args) {
        RemoveAllOccurrencesofaSubstring raoss = new RemoveAllOccurrencesofaSubstring();
        System.out.println(raoss.removeOccurrences("daabcbaabcbc", "abc"));
    }
}
