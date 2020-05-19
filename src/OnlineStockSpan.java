
import java.util.Stack;

public class OnlineStockSpan {

    Stack<Integer> stack;

    public OnlineStockSpan() {
        this.stack = new Stack();
    }

    public int next(int price) {
        int count = 1;
        Stack<Integer> temp = new Stack();
        temp.addAll(this.stack);
        while (!temp.isEmpty() && temp.peek() <= price) {
            count++;
            temp.pop();
        }
        stack.add(price);
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
