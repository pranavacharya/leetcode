
public class FIrstBadVersion {

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        FIrstBadVersion fbv = new FIrstBadVersion();
        System.out.println(fbv.firstBadVersion(5));
    }
}
