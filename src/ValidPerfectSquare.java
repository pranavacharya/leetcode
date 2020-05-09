
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else if (mid * mid > num) {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.println(vps.isPerfectSquare(16));
        System.out.println(vps.isPerfectSquare(2147483647));
    }
}
