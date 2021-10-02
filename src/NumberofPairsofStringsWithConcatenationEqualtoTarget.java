
public class NumberofPairsofStringsWithConcatenationEqualtoTarget {

    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals(nums[i] + nums[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberofPairsofStringsWithConcatenationEqualtoTarget npswcet = new NumberofPairsofStringsWithConcatenationEqualtoTarget();
        String[] nums = new String[]{"1", "1", "1"};
        System.out.println(npswcet.numOfPairs(nums, "11"));
    }
}
