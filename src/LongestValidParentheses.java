
import java.util.Stack;


public class LongestValidParentheses {

    class Node {

        char c;
        int count;

        public Node(char c, int val) {
            this.c = c;
            this.count = val;
        }
    }

    public int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack();
        stack.push(new Node('.', 0));
        for (int i = 0; i < s.length(); i++) {
            if (stack.peek().c == '.') {
                stack.push(new Node(s.charAt(i), 0));
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(new Node(s.charAt(i), 0));
                } else {
                    if (stack.peek().c == '(') {
                        Node node = stack.pop();
                        int val = node.count;
                        Node last = stack.pop();
                        last.count += (val + 1);
                        stack.push(last);
                    } else {
                        stack.push(new Node(')', 0));
                    }
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans = Math.max(stack.pop().count, ans);
        }

        return ans * 2;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(")()())"));
    }
}
