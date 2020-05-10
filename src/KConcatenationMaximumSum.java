
public class KConcatenationMaximumSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length * k; i++) {
            sum += arr[i % arr.length];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String args[]) {
        KConcatenationMaximumSum kcms = new KConcatenationMaximumSum();
        int[] arr = new int[]{1, -2, 1};
        System.out.println(kcms.kConcatenationMaxSum(arr, 5));
    }
}
