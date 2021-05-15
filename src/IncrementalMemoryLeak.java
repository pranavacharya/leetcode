
import java.util.Arrays;
import java.util.PriorityQueue;

public class IncrementalMemoryLeak {

    public int[] memLeak(int memory1, int memory2) {
        int[] mem = new int[]{memory1, memory2};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (mem[b] != mem[a] ? mem[b] - mem[a] : a - b));
        int index = 1;
        maxHeap.add(0);
        maxHeap.add(1);
        while (mem[maxHeap.peek()] >= index) {
            int max = maxHeap.poll();
            mem[max] -= index;
            maxHeap.add(max);
            index++;
        }
        return new int[]{index, mem[0], mem[1]};
    }

    public static void main(String[] args) {
        IncrementalMemoryLeak iml = new IncrementalMemoryLeak();
        System.out.println(Arrays.toString(iml.memLeak(9, 6)));
    }
}
