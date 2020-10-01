
import java.util.ArrayDeque;
import java.util.Deque;

public class NumberofRecentCalls {

    private Deque<Integer> deque;

    public NumberofRecentCalls() {
        this.deque = new ArrayDeque();
    }

    public int ping(int t) {
        this.deque.addLast(t);
        while (!this.deque.isEmpty()) {
            if (this.deque.peekFirst() < t - 3000) {
                this.deque.removeFirst();
            } else {
                break;
            }
        }
        return this.deque.size();
    }

    public static void main(String args[]) {
        NumberofRecentCalls ncr = new NumberofRecentCalls();
        System.out.println(ncr.ping(1));
        System.out.println(ncr.ping(100));
        System.out.println(ncr.ping(3001));
        System.out.println(ncr.ping(3002));
    }
}
