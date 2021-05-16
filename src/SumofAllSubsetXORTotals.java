
public class SumofAllSubsetXORTotals {

    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        subSet(nums, 0, 0);
        return this.sum;
    }

    private void subSet(int[] nums, int index, int xor) {
        if (index == nums.length) {
            this.sum += xor;
            return;
        }
        subSet(nums, index + 1, xor);
        subSet(nums, index + 1, xor ^ nums[index]);
    }

    public static void main(String[] args) {
        SumofAllSubsetXORTotals sasxt = new SumofAllSubsetXORTotals();
        int[] nums = new int[]{1, 3};
        System.out.println(sasxt.subsetXORSum(nums));
    }
}
