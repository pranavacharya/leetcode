
import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianfromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.minHeap.add(num);
        balanceHeap();
    }

    public double findMedian() {
        if (this.maxHeap.size() == this.minHeap.size()) {
            return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
        } else {
            return this.maxHeap.peek();
        }
    }

    private void balanceHeap() {
        while (!this.maxHeap.isEmpty() && !this.minHeap.isEmpty()
                && this.maxHeap.peek() > this.minHeap.peek()) {
            this.minHeap.add(this.maxHeap.poll());
        }
        int sizeDiff = this.minHeap.size() - this.maxHeap.size();
        if (sizeDiff == 0) {
            return;
        }
        if (sizeDiff % 2 == 0) {
            for (int i = 0; i < sizeDiff / 2; i++) {
                this.maxHeap.add(this.minHeap.poll());
            }
        } else {
            for (int i = 0; i < (sizeDiff + 1) / 2; i++) {
                this.maxHeap.add(this.minHeap.poll());
            }
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
