
import java.util.Stack;

public class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack();
    }

    public void push(int val) {
        if (this.stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int min = Math.min(this.stack.peek()[1], val);
            stack.push(new int[]{val, min});
        }
    }

    public void pop() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
        }
    }

    public int top() {
        return this.stack.peek()[0];
    }

    public int getMin() {
        return this.stack.peek()[1];
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
