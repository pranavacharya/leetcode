
public class CountAllValidPickupandDeliveryOptions {

    private int mod = (int) 1e9 + 7;

    public int countOrders(int n) {
        long count = 1;

        // n! * (1 * 3 * 5 ... 2n-1)
        for (int i = 1; i <= n; i++) {
            count = (count % mod * i % mod) % mod;
        }

        for (int i = 1; i < 2 * n; i += 2) {
            count = (count % mod * i % mod) % mod;
        }

        return (int) count;
    }

    public static void main(String[] args) {
        CountAllValidPickupandDeliveryOptions cavpdo = new CountAllValidPickupandDeliveryOptions();
        System.out.println(cavpdo.countOrders(3));
    }
}
