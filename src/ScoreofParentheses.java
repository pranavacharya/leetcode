
import java.util.Stack;

public class ScoreofParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        int score = 0;
        int index = 0;
        while (index < S.length()) {
            if (S.charAt(index) == '(') {
                stack.push(0);
            } else {
                int localsrc = stack.pop();
                localsrc *= 2;
                if (localsrc == 0) {
                    localsrc++;
                }
                if (stack.isEmpty()) {
                    score += localsrc;
                } else {
                    int lastState = stack.pop();
                    stack.push(lastState + localsrc);
                }
            }
            index++;
        }
        return score;
    }

    public static void main(String args[]) {
        ScoreofParentheses sop = new ScoreofParentheses();
        System.out.println(sop.scoreOfParentheses("((()())())"));
    }
}
