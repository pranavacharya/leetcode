
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }
            if (A[i] < A[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String args[]) {
        MonotonicArray ma = new MonotonicArray();
        int[] A = {4, 3, 2, 2, 1};
        System.out.println(ma.isMonotonic(A));
    }
}
