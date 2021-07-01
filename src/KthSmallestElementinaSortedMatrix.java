
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (matrix[b[0]][b[1]] - matrix[a[0]][a[1]]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.add(new int[]{i, j});
            }
        }
        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
        int[] ans = maxHeap.peek();
        return matrix[ans[0]][ans[1]];
    }

    public static void main(String[] args) {
        KthSmallestElementinaSortedMatrix ksesm = new KthSmallestElementinaSortedMatrix();
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(ksesm.kthSmallest(matrix, 8));
    }
}
