
import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    // maxHeap
    private PriorityQueue<Integer> first;
    // minHeap
    private PriorityQueue<Integer> second;

    /**
     * initialize your data structure here.
     */
    public FindMedianfromDataStream() {
        this.first = new PriorityQueue<>((a, b) -> (b - a));
        this.second = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.second.add(num);
        balance();
    }

    public double findMedian() {
        if (this.first.size() > this.second.size()) {
            return this.first.peek();
        } else {
            double ans = (double) (this.first.peek() + this.second.peek()) / 2.0;
            return ans;
        }
    }

    private void balance() {
        while (!second.isEmpty() && !first.isEmpty() && second.peek() < first.peek()) {
            first.add(second.poll());
        }

        while (second.size() > first.size()) {
            first.add(second.poll());
        }

        while (first.size() > second.size() + 1) {
            second.add(first.poll());
        }
    }

    public static void main(String[] args) {
        FindMedianfromDataStream fmds = new FindMedianfromDataStream();
        fmds.addNum(1);
        fmds.addNum(2);
        System.out.println(fmds.findMedian());
        fmds.addNum(3);
        System.out.println(fmds.findMedian());
//        fmds.addNum(-1);
//        System.out.println(fmds.findMedian());
//        fmds.addNum(-2);
//        System.out.println(fmds.findMedian());
//        fmds.addNum(-3);
//        System.out.println(fmds.findMedian());
//        fmds.addNum(-4);
//        System.out.println(fmds.findMedian());
//        fmds.addNum(-5);
//        System.out.println(fmds.findMedian());
    }
}
