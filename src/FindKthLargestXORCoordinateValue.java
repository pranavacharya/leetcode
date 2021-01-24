
import java.util.PriorityQueue;

public class FindKthLargestXORCoordinateValue {

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] ^ dp[i + 1][j] ^ dp[i][j] ^ matrix[i][j];
                minHeap.add(dp[i + 1][j + 1]);
                if (minHeap.size() > k) {
                    minHeap.remove();
                }
            }
        }
        return minHeap.remove();
    }

    public static void main(String args[]) {
        FindKthLargestXORCoordinateValue kklxcv = new FindKthLargestXORCoordinateValue();
        int[][] matrix = new int[][]{{5, 2}, {1, 6}};
        System.out.println(kklxcv.kthLargestValue(matrix, 1));
    }
}
