
public class FindMinimuminRotatedSortedArray2 {

    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else {
            int index = nums.length - 1;
            while (index > 0) {
                if (nums[index - 1] > nums[index]) {
                    break;
                }
                index--;
            }
            return nums[index];
        }
    }

    public static void main(String args[]) {
        FindMinimuminRotatedSortedArray2 fmrsa = new FindMinimuminRotatedSortedArray2();
        int[] nums = new int[]{2, 2, 2, 3, 5, 0, 1, 2};
        System.out.println(fmrsa.findMin(nums));
    }
}
