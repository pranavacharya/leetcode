
import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[index] > k) {
                count++;
                index = i;
            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        PartitionArraySuchThatMaximumDifferenceIsK pasmdk = new PartitionArraySuchThatMaximumDifferenceIsK();
        int[] nums = new int[]{3, 6, 1, 2, 5, 7, 8};
        System.out.println(pasmdk.partitionArray(nums, 2));
    }
}
