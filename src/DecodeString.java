
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty()) {
                    if (stack.peek() == '[') {
                        break;
                    } else {
                        temp.append(stack.pop());
                    }
                }
                stack.pop();
                int times = 0;
                int digit = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    times += Character.getNumericValue(stack.pop()) * digit;
                    digit *= 10;
                }
                temp = temp.reverse();
                for (int i = 0; i < times; i++) {
                    for (int j = 0; j < temp.length(); j++) {
                        stack.push(temp.charAt(j));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        DecodeString ds = new DecodeString();
//        System.out.println(ds.decodeString("3[a]2[bc]"));
//        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("100[leetcode]"));
    }
}
