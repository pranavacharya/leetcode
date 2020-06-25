
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        } while (tortoise != hare);
        tortoise = nums[0];
        while (tortoise != hare) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return hare;
    }

    public static void main(String args[]) {
        FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
        int[] arr = new int[]{1, 3, 4, 2, 2};
        System.out.println(fdn.findDuplicate(arr));
    }
}
