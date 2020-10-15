
public class Sqrtx {

    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

    public static void main(String args[]) {
        Sqrtx s = new Sqrtx();
        System.out.println(s.mySqrt(2147395599));
    }
}
