
public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int start = 0;
        while (j < nums.length) {
            i = j;
            while (j + 1 < nums.length) {
                if (nums[i] == nums[j + 1]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j != i) {
                nums[start] = nums[i];
                nums[start + 1] = nums[i];
                start += 2;
            } else {
                nums[start] = nums[i];
                start++;
            }
            j++;
        }
        return start;
    }

    public static void main(String args[]) {
        RemoveDuplicatesfromSortedArrayII rdfsa = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = rdfsa.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
