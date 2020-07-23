
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        ArrayList<Integer> list = new ArrayList();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        list.addAll(set);
        int[] ans = new int[2];
        for (int i = 0; i < 2; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        SingleNumber3 sn3 = new SingleNumber3();
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(sn3.singleNumber(nums)));
    }
}
