
import java.util.Stack;

public class OnlineStockSpan {

    Stack<Integer> stack;
    Stack<Integer> state;

    public OnlineStockSpan() {
        this.stack = new Stack();
        this.state = new Stack();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek() <= price) {
            stack.pop();
            count = count + state.pop();
        }
        stack.add(price);
        state.add(count);
        return count;
    }

    public static void main(String args[]) {
        OnlineStockSpan S = new OnlineStockSpan();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));
    }
}
