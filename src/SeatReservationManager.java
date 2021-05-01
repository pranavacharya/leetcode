
import java.util.PriorityQueue;

public class SeatReservationManager {

    int capacity;
    PriorityQueue<Integer> minHeap;

    public SeatReservationManager(int n) {
        this.capacity = n;
        this.minHeap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            this.minHeap.add(i);
        }
    }

    public int reserve() {
        return this.minHeap.poll();
    }

    public void unreserve(int seatNumber) {
        this.minHeap.add(seatNumber);
    }
}
