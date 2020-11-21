
public class NumbersAtMostNGivenDigitSet {

    private int count = 0;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] nums = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        dfs(0, n, nums);
        return this.count;
    }

    private void dfs(long path, long n, int[] digits) {
        if (path <= n) {
            if (path != 0) {
                this.count++;
            }
            for (int i = 0; i < digits.length; i++) {
                dfs(path * 10 + digits[i], n, digits);
            }
        }
    }

    public static void main(String args[]) {
        NumbersAtMostNGivenDigitSet nmngds = new NumbersAtMostNGivenDigitSet();
        String[] digits = new String[]{"3", "4", "8"};
        System.out.println(nmngds.atMostNGivenDigitSet(digits, 4));
    }
}
