
import java.util.ArrayList;
import java.util.Arrays;

public class FindtheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList();
        helper(nums, k, 0, nums.length - k, list);
        int[] res = list.stream().mapToInt(i -> i).toArray();
        return res;
    }

    private void helper(int[] nums, int k, int start, int end, ArrayList<Integer> results) {
        if (k == 0) {
            return;
        }

        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        results.add(min);
        helper(nums, k - 1, minIndex + 1, nums.length - (k - 1), results);
    }

    public static void main(String args[]) {
        FindtheMostCompetitiveSubsequence fmcs = new FindtheMostCompetitiveSubsequence();
        int[] nums = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
        System.out.println(Arrays.toString(fmcs.mostCompetitive(nums, 4)));
    }
}
