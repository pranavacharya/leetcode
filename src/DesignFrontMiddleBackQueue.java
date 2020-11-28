
import java.util.ArrayDeque;
import java.util.Deque;

public class DesignFrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public DesignFrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        left.offerLast(val);
        rebalance();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        rebalance();
    }

    public int popFront() {
        int res = -1;
        if (!left.isEmpty()) {
            res = left.pollFirst();
        } else if (!right.isEmpty()) {
            res = right.pollFirst();
        }
        rebalance();
        return res;
    }

    public int popMiddle() {
        int res = -1;
        boolean isRight = (left.size() + right.size()) % 2 == 1;
        if (isRight && !right.isEmpty()) {
            res = right.pollFirst();
        } else if (!left.isEmpty()) {
            res = left.pollLast();
        }
        rebalance();
        return res;
    }

    public int popBack() {
        int res = -1;
        if (!right.isEmpty()) {
            res = right.pollLast();
        } else if (!left.isEmpty()) {
            res = left.pollLast();
        }
        rebalance();
        return res;
    }

    private void rebalance() {
        while (left.size() < right.size() - 1) {
            left.offerLast(right.pollFirst());
        }
        while (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
    }

    public static void main(String args[]) {
        DesignFrontMiddleBackQueue q = new DesignFrontMiddleBackQueue();
//        q.pushFront(1);   // [1]
//        q.pushBack(2);    // [1, 2]
//        q.pushMiddle(3);  // [1, 3, 2]
//        q.pushMiddle(4);  // [1, 4, 3, 2]
//        System.out.println(q.popFront());    // return 1 -> [4, 3, 2]
//        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
//        System.out.println(q.popMiddle());    // return 4 -> [2]
//        System.out.println(q.popBack());      // return 2 -> []
//        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)

//        q.pushMiddle(1);
//        q.pushMiddle(2);
//        q.pushMiddle(3);
//        System.out.println(q.popMiddle());
//        System.out.println(q.popMiddle());
//        System.out.println(q.popMiddle());
        q.pushMiddle(1);
        System.out.println(q.popMiddle());
        q.pushMiddle(2);
        System.out.println(q.popMiddle());
        q.pushFront(3);
        q.pushMiddle(4);
        q.pushMiddle(5);
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        q.pushBack(6);
        System.out.println(q.popMiddle());

//        q.pushFront(1);
//        q.pushFront(2);
//        q.pushFront(3);
//        q.pushFront(4);
//        System.out.println(q.popBack());
//        System.out.println(q.popBack());
//        System.out.println(q.popBack());
//        System.out.println(q.popBack());
    }
}
