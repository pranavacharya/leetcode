
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        PriorityQueue<Integer> maxHeapA = new PriorityQueue<>((a, b) -> (A[a] - A[b]));
        PriorityQueue<Integer> maxHeapB = new PriorityQueue<>((a, b) -> (B[a] - B[b]));
        for (int i = 0; i < A.length; i++) {
            maxHeapA.add(i);
            maxHeapB.add(i);
        }

        ArrayList<Integer> rem = new ArrayList();
        while (!maxHeapB.isEmpty()) {
            int curr = maxHeapB.peek();
            while (!maxHeapA.isEmpty() && B[curr] >= A[maxHeapA.peek()]) {
                rem.add(maxHeapA.poll());
            }
            if (!maxHeapA.isEmpty()) {
                int index = maxHeapA.poll();
                res[curr] = A[index];
            } else {
                break;
            }
            maxHeapB.poll();
        }
        for (int i = 0; i < rem.size(); i++) {
            res[maxHeapB.poll()] = A[rem.get(i)];
        }
        return res;
    }

    public static void main(String[] args) {
        AdvantageShuffle as = new AdvantageShuffle();
        int[] A = new int[]{12, 24, 8, 32};
        int[] B = new int[]{13, 25, 32, 11};
        System.out.println(Arrays.toString(as.advantageCount(A, B)));
    }
}
