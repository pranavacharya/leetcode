
import java.util.Arrays;
import java.util.Stack;

public class IteratorforCombination {

    public class State {

        int index;
        String soFar;

        public State(int index, String soFar) {
            this.index = index;
            this.soFar = soFar;
        }
    }

    Stack<State> stack;
    String input;
    int length;
    String next;

    public IteratorforCombination(String characters, int combinationLength) {
        char[] arr = characters.toCharArray();
        Arrays.sort(arr);
        this.input = new String(arr);
        this.length = combinationLength;
        this.next = null;
        stack = new Stack();
        stack.push(new State(0, ""));
        findOne();
    }

    private void findOne() {
        boolean status = true;
        while (status && !stack.isEmpty()) {
            State curr = stack.pop();
            int index = curr.index;
            String soFar = curr.soFar;
            if (soFar.length() == length) {
                next = soFar;
                status = false;
            } else if (index == input.length()) {
                continue;
            } else {
                stack.add(new State(index + 1, soFar));
                String temp = soFar + ("" + input.charAt(index));
                if (temp.length() <= length) {
                    stack.add(new State(index + 1, temp));
                }
            }
        }
    }

    public String next() {
        String temp = next;
        next = null;
        findOne();
        return temp;
    }

    public boolean hasNext() {
        return next != null;
    }

    public static void main(String args[]) {
        IteratorforCombination tc = new IteratorforCombination("abc", 2);
        System.out.println(tc.next());
        System.out.println(tc.hasNext());
        System.out.println(tc.next());
        System.out.println(tc.hasNext());
        System.out.println(tc.next());
        System.out.println(tc.hasNext());
    }
}
