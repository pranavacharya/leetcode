
import java.util.Stack;

public class ScoreofParentheses {

    public int scoreOfParentheses(String S) {
        int ans = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                int local = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    local += (stack.pop() - '0');
                }
                stack.pop();
                if (local == 0) {
                    local++;
                } else {
                    local *= 2;
                }
                stack.push((char) (local + '0'));
            }
        }
        while (!stack.isEmpty()) {
            ans += (stack.pop() - '0');
        }
        return ans;
    }

    public static void main(String args[]) {
        ScoreofParentheses sop = new ScoreofParentheses();
        System.out.println(sop.scoreOfParentheses("(()(()))"));
        System.out.println(sop.scoreOfParentheses("((()())())"));
    }
}
