
import java.util.Stack;

public class ScoreofParentheses {

    public class State {

        char b;
        int score;

        public State(char b, int score) {
            this.b = b;
            this.score = score;
        }
    }

    public int scoreOfParentheses(String S) {
        Stack<State> stack = new Stack();
        int score = 0;
        int index = 0;
        while (index < S.length()) {
            if (S.charAt(index) == '(') {
                stack.push(new State('(', 0));
            } else {
                State current = stack.pop();
                int localsrc = current.score;
                localsrc *= 2;
                if (localsrc == 0) {
                    localsrc++;
                }
                if (stack.isEmpty()) {
                    score += localsrc;
                } else {
                    State lastState = stack.pop();
                    stack.push(new State(lastState.b, lastState.score + localsrc));
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
