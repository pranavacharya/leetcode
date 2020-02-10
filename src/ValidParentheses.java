
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        String Open = "({[";
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            if (Open.indexOf(arr[i]) != -1) {
                stack.push(arr[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (map.get(arr[i]) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
            i++;
        }
        return (stack.empty());
    }

    public static void main(String args[]) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{[]}"));
    }
}
