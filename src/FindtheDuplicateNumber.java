
import java.util.HashSet;

public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static void main(String args[]) {
        FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
        int[] arr = new int[]{1, 3, 4, 2, 2};
        System.out.println(fdn.findDuplicate(arr));
    }
}
