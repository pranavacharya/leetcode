
import java.util.Stack;

public class MaximumNestingDepthoftheParentheses {

    public int maxDepth(String s) {
        int maxDepth = 0;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                maxDepth = Math.max(maxDepth, stack.size());
                stack.pop();
            }
        }
        return maxDepth;
    }

    public static void main(String args[]) {
        MaximumNestingDepthoftheParentheses mndop = new MaximumNestingDepthoftheParentheses();
        System.out.println(mndop.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
