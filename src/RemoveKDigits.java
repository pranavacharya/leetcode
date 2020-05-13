
import java.util.ArrayList;
import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        char[] arr = num.toCharArray();
        int index = 0;
        while (index < arr.length) {
            while (!stack.isEmpty() && stack.peek() > arr[index] && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(arr[index]);
            index++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        ArrayList<Character> list = new ArrayList();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString().isBlank() ? "0" : sb.toString();
    }

    public static void main(String args[]) {
        RemoveKDigits rkd = new RemoveKDigits();
        System.out.println(rkd.removeKdigits("1432219", 3));
        System.out.println(rkd.removeKdigits("1432299", 3));
        System.out.println(rkd.removeKdigits("10200", 1));
        System.out.println(rkd.removeKdigits("10", 2));
    }
}
