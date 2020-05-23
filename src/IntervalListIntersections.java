
import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        Arrays.sort(A, (a, b) -> Double.compare(a[0], b[0]));
        Arrays.sort(B, (a, b) -> Double.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] > B[j][1]) {
                j++;
                continue;
            }
            if (B[j][0] > A[i][1]) {
                i++;
                continue;
            }
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            list.add(new int[]{start, end});
            if (A[i][1] > B[j][1]) {
                j++;
            } else if (B[j][1] > A[i][1]) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        int[][] ans = new int[list.size()][2];
        for (i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        IntervalListIntersections ili = new IntervalListIntersections();
        int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(ili.intervalIntersection(A, B)));
    }
}
