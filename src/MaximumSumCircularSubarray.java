
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i % A.length] < 0) {
                max = Math.max(max, A[i % A.length]);
                continue;
            }
            int sum = A[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
            for (int j = i + 1; j < 2 * A.length; j++) {
                if (j % A.length == i) {
                    break;
                }
                sum += A[j % A.length];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }

            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumSumCircularSubarray mscs = new MaximumSumCircularSubarray();
//        int[] A = new int[]{1, -2, 3, -2};
        int[] A = new int[]{5, -3, 5};
        System.out.println(mscs.maxSubarraySumCircular(A));
    }
}
