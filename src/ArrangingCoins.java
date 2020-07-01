
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = (mid * (mid + 1)) / 2;
            if (count == n) {
                return (int) mid;
            } else if (n < count) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    public static void main(String args[]) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(5));
    }
}
