
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return true;
        }
        int last = A[0];
        int sum = 0;
        int same = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > last) {
                sum++;
            } else if (A[i] == last) {
                same++;
            } else {
                sum--;
            }
            last = A[i];
        }
        return (Math.abs(sum) == A.length - 1 - same);
    }

    public static void main(String args[]) {
        MonotonicArray ma = new MonotonicArray();
        int[] A = {1, 2, 3, 4};
        System.out.println(ma.isMonotonic(A));
    }
}
