
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                num *= -1;
            }
            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        FindAllDuplicatesinanArray fdia = new FindAllDuplicatesinanArray();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(fdia.findDuplicates(nums));
    }
}
