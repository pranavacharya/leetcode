
public class MinimumOperationstoMakeArrayEqual {

    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2 + 1;
        }
        int count = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            count += n - arr[i];
        }
        return count;
    }

    public static void main(String args[]) {
        MinimumOperationstoMakeArrayEqual momae = new MinimumOperationstoMakeArrayEqual();
        System.out.println(momae.minOperations(6));
        System.out.println(momae.minOperations(3));
    }
}
