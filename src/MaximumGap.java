
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // Radix sort
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int exp = 1;
        int R = 10;
        int[] aux = new int[nums.length];
        while (max / exp > 0) {
            int[] count = new int[R];

            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }

        int ans = 0;
        for (int i = 1; i < aux.length; i++) {
            ans = Math.max(ans, aux[i] - aux[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        int[] nums = new int[]{3, 6, 9, 1};
        System.out.println(mg.maximumGap(nums));
    }
}
