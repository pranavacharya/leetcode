
import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 0;
        int low = 0;
        int high = position[position.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, mid, m)) {
                min = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return min;
    }

    public boolean canPlace(int[] position, int distance, int m) {
        int count = 1;
        int last = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - last >= distance) {
                count++;
                last = position[i];
            }
        }
        return count >= m;
    }

    public static void main(String args[]) {
        MagneticForceBetweenTwoBalls mfbtb = new MagneticForceBetweenTwoBalls();
        int[] position = new int[]{5, 4, 3, 2, 1, 100};
        System.out.println(mfbtb.maxDistance(position, 2));
    }
}
