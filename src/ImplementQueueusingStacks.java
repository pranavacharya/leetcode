
import java.util.Stack;

public class ImplementQueueusingStacks {

    Stack<Integer> st;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueusingStacks() {
        this.st = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> temp = new Stack();
        while (!this.st.isEmpty()) {
            temp.add(this.st.pop());
        }
        this.st.push(x);
        while (!temp.empty()) {
            this.st.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return this.st.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return this.st.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.st.isEmpty();
    }
}
