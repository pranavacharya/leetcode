
public class FormLargestIntegerWithDigitsThatAdduptoTarget {

    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        return dfs(cost, target, dp);
    }

    String dfs(int[] cost, int target, String[] dp) {
        if (target < 0) {
            return "0";
        }
        if (target == 0) {
            return "";
        }
        if (dp[target] != null) {
            return dp[target];
        }
        String ans = "0";
        for (int d = 9; d >= 1; d--) {
            String curr = dfs(cost, target - cost[d - 1], dp);
            if (curr.equals("0")) {
                continue;
            }
            curr = d + curr;
            if (ans.equals("0") || curr.length() > ans.length()) {
                ans = curr;
            }
        }
        return dp[target] = ans;
    }

    public static void main(String args[]) {
        FormLargestIntegerWithDigitsThatAdduptoTarget fliwdtat = new FormLargestIntegerWithDigitsThatAdduptoTarget();
//        int[] arr = new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5};
//        System.out.println(fliwdtat.largestNumber(arr, 9));
//        int[] arr = new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40};
//        System.out.println(fliwdtat.largestNumber(arr, 47));
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 3, 2};
        System.out.println(fliwdtat.largestNumber(arr, 10));
    }
}
