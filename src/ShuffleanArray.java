
import java.util.Arrays;
import java.util.Random;

public class ShuffleanArray {

    private int[] original;
    Random random = new Random();

    public ShuffleanArray(int[] nums) {
        this.original = nums;
    }

    public int[] reset() {
        return this.original;
    }

    public int[] shuffle() {
        int[] ans = this.original.clone();
        for (int j = 1; j < ans.length; j++) {
            int i = random.nextInt(j + 1);
            swap(ans, i, j);
        }
        return ans;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ShuffleanArray sa = new ShuffleanArray(nums);
        System.out.println(Arrays.toString(sa.reset()));
        System.out.println(Arrays.toString(sa.shuffle()));
    }
}
