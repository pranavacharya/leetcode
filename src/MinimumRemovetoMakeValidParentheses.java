
import java.util.HashSet;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {

    class Node {

        char c;
        int index;

        public Node(char c, int i) {
            this.c = c;
            this.index = i;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Node> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(new Node(s.charAt(i), i));
            } else if (s.charAt(i) == ')') {
                if (stack.peek().c == '(') {
                    stack.pop();
                } else {
                    stack.push(new Node(s.charAt(i), i));

                }
            } else {
                stack.push(new Node(s.charAt(i), i));
            }
        }

        HashSet<Integer> toDiscard = new HashSet();
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            toDiscard.add(curr.index);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (toDiscard.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        MinimumRemovetoMakeValidParentheses mrmvp = new MinimumRemovetoMakeValidParentheses();
        System.out.println(mrmvp.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
