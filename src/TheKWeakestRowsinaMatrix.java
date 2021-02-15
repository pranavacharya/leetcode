
import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sumarr = new int[mat.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (sumarr[b] - sumarr[a] == 0 ? b - a : sumarr[b] - sumarr[a]));
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sum++;
                }
            }
            sumarr[i] = sum;
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    public static void main(String args[]) {
        TheKWeakestRowsinaMatrix tkwrm = new TheKWeakestRowsinaMatrix();
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(tkwrm.kWeakestRows(mat, 3)));
    }
}
