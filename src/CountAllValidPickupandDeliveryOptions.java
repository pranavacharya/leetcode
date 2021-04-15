
public class CountAllValidPickupandDeliveryOptions {

    private int mod = (int) 1e9 + 7;
    private int count = 0;

    public int countOrders(int n) {
        boolean[] visited = new boolean[n * 2];
        backtrack(0, 2 * n, visited);
        return this.count;
    }

    private void backtrack(int index, int n, boolean[] visited) {
        if (index == n) {
            this.count = (this.count % mod + 1 % mod) % mod;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i % 2 == 0) {
                visited[i] = true;
                backtrack(index + 1, n, visited);
                visited[i] = false;
            } else {
                if (visited[i - 1]) {
                    visited[i] = true;
                    backtrack(index + 1, n, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        CountAllValidPickupandDeliveryOptions cavpdo = new CountAllValidPickupandDeliveryOptions();
        System.out.println(cavpdo.countOrders(3));
    }
}
