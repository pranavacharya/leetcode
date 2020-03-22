
import java.util.ArrayList;
import java.util.Arrays;

public class CreateTargetArrayintheGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[list.size()];
        int pointer = 0;
        for (int i : list) {
            res[pointer] = i;
            pointer++;
        }
        return res;
    }

    public static void main(String args[]) {
        CreateTargetArrayintheGivenOrder ctaitgo = new CreateTargetArrayintheGivenOrder();
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(ctaitgo.createTargetArray(nums, index)));
    }
}
