
import java.util.ArrayList;
import java.util.Arrays;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int frequency = nums[i];
            int value = nums[i + 1];
            while (frequency > 0) {
                list.add(value);
                frequency--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String args[]) {
        DecompressRunLengthEncodedList drlenl = new DecompressRunLengthEncodedList();
        int[] nums = new int[]{1, 1, 2, 3};
        System.out.println(Arrays.toString(drlenl.decompressRLElist(nums)));
    }
}
