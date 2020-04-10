
import java.util.ArrayList;

public class MinStack {

    private ArrayList<Integer> stack;
    private int top;
    private int min;

    public MinStack() {
        this.stack = new ArrayList();
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        this.stack.add(x);
        this.top++;
        this.min = Math.min(this.min, x);
    }

    public void pop() {
        int val = this.stack.get(top);
        this.stack.remove(top);
        this.top--;
        if (this.min == val) {
            int newmin = Integer.MAX_VALUE;
            for (int i = 0; i < this.stack.size(); i++) {
                newmin = Math.min(this.stack.get(i), newmin);
            }
            this.min = newmin;
        }
    }

    public int top() {
        return this.stack.get(top);
    }

    public int getMin() {
        return this.min;
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
