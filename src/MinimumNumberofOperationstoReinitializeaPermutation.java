
public class MinimumNumberofOperationstoReinitializeaPermutation {

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int ops = 0;
        while (true) {
            ops++;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            if (isSame(perm)) {
                break;
            }
        }
        return ops;
    }

    private boolean isSame(int[] perm) {
        for (int i = 0; i < perm.length; i++) {
            if (i != perm[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoReinitializeaPermutation mprp
                = new MinimumNumberofOperationstoReinitializeaPermutation();
        System.out.println(mprp.reinitializePermutation(4));
    }
}
