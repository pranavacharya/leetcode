
public class MinimumOperationstoMakeArrayEqual {

    public int minOperations(int n) {
        int ops = 0;
        for (int i = 0; i < n / 2; i++) {
            ops += (n - ((2 * i) + 1));
        }
        return ops;
    }

    public static void main(String args[]) {
        MinimumOperationstoMakeArrayEqual momae = new MinimumOperationstoMakeArrayEqual();
        System.out.println(momae.minOperations(6));
        System.out.println(momae.minOperations(3));
    }
}
