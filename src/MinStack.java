
import java.util.ArrayList;

public class MinStack {

    private ArrayList<Integer> stack;
    private int top;

    public MinStack() {
        this.stack = new ArrayList();
        this.top = -1;
    }

    public void push(int x) {
        this.stack.add(x);
        this.top++;
    }

    public void pop() {
        this.stack.remove(top);
        this.top--;
    }

    public int top() {
        return this.stack.get(top);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.stack.size(); i++) {
            min = Math.min(this.stack.get(i), min);
        }
        return min;
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
