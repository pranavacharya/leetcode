
public class MinimizedMaximumofProductsDistributedtoAnyStore {

    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 100000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(quantities, mid, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canDistribute(int[] quantities, int limit, int n) {
        int taken = 0;
        for (int i = 0; i < quantities.length; i++) {
            taken += quantities[i] / limit;
            if (quantities[i] % limit != 0) {
                taken++;
            }
        }
        return taken <= n;
    }

    public static void main(String[] args) {
        MinimizedMaximumofProductsDistributedtoAnyStore mmpdas = new MinimizedMaximumofProductsDistributedtoAnyStore();
        int[] quantities = new int[]{15, 10, 10};
//        int[] quantities = new int[]{11, 6};
        System.out.println(mmpdas.minimizedMaximum(9, quantities));
    }
}
