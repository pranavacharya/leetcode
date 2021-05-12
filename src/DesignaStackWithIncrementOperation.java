
import java.util.HashMap;
import java.util.Stack;

public class DesignaStackWithIncrementOperation {

    int maxSize;
    Stack<Integer> stack;
    HashMap<Integer, Integer> incMap;

    public DesignaStackWithIncrementOperation(int maxSize) {
        this.stack = new Stack();
        this.maxSize = maxSize;
        this.incMap = new HashMap();
    }

    public void push(int x) {
        if (this.stack.size() != this.maxSize) {
            this.stack.push(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int height = stack.size();
            int ans = stack.pop();
            if (this.incMap.containsKey(height)) {
                ans += this.incMap.get(height);
                this.incMap.put(height - 1, this.incMap.getOrDefault(height - 1, 0) + this.incMap.get(height));
                this.incMap.remove(height);
                if (this.incMap.containsKey(0)) {
                    this.incMap.remove(0);
                }
            }
            return ans;
        }
    }

    public void increment(int k, int val) {
        if (k > this.stack.size()) {
            k = stack.size();
        }
        this.incMap.put(k, this.incMap.getOrDefault(k, 0) + val);
    }

    public static void main(String[] args) {
        DesignaStackWithIncrementOperation obj = new DesignaStackWithIncrementOperation(5);
        obj.push(1);
        System.out.println(obj.pop());
        obj.increment(1, 2);
    }
}
