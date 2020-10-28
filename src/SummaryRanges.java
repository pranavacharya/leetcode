
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        if (nums.length == 0) {
            return list;
        }
        int last = nums[0];
        String element = "" + last;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last + 1) {
                if (Integer.parseInt(element) != nums[i - 1]) {
                    element = element.concat("->" + nums[i - 1]);
                }
                list.add(element);
                element = "" + nums[i];
            }
            last = nums[i];
        }
        if (Integer.parseInt(element) != nums[nums.length - 1]) {
            element = element.concat("->" + nums[nums.length - 1]);
        }
        list.add(element);
        return list;
    }

    public static void main(String args[]) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(sr.summaryRanges(nums));
    }
}
