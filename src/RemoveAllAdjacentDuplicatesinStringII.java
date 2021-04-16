
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {

    class Node {

        char c;
        int count;

        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(arr[i], 1));
                continue;
            }

            Node top = stack.peek();
            if (top.c == arr[i]) {
                if (top.count == k - 1) {
                    for (int j = 1; j < k; j++) {
                        stack.pop();
                    }
                } else {
                    stack.push(new Node(arr[i], top.count + 1));
                }
            } else {
                stack.push(new Node(arr[i], 1));
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop().c;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesinStringII raads = new RemoveAllAdjacentDuplicatesinStringII();
        System.out.println(raads.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
