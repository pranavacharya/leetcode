
public class FindNumberswithEvenNumberofDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (countDigit(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int countDigit(int num) {
        int digit = 0;
        while (num > 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }

    public static void main(String args[]) {
        FindNumberswithEvenNumberofDigits fnwend = new FindNumberswithEvenNumberofDigits();
        int[] nums = new int[]{555, 901, 482, 1771};
        System.out.println(fnwend.findNumbers(nums));
    }
}
