
import java.util.Stack;

public class GoalParserInterpretation {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    sb.append('o');
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    sb.append("al");
                    stack.pop();
                }
            } else {
                stack.push(command.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        GoalParserInterpretation gpi = new GoalParserInterpretation();
        System.out.println(gpi.interpret("G()(al)"));
        System.out.println(gpi.interpret("G()()()()(al)"));
        System.out.println(gpi.interpret("(al)G(al)()()G"));
    }
}
