
public class RemoveOneElementtoMaketheArrayStrictlyIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        if (isIncreasing(nums)) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[nums.length - 1];
            int[] arr2 = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                arr[index++] = nums[j];
            }
            if (isIncreasing(arr)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveOneElementtoMaketheArrayStrictlyIncreasing roemssi
                = new RemoveOneElementtoMaketheArrayStrictlyIncreasing();
        int[] nums = new int[]{1, 2, 10, 5, 7};
        System.out.println(roemssi.canBeIncreasing(nums));
    }
}
