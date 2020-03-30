
public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += countDivisor(num);
        }
        return sum;
    }

    public int countDivisor(int i) {
        int count = 2;
        int sum = 1 + i;
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                count++;
                sum += j;
            }
        }
        if (count == 4) {
            return sum;
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        FourDivisors fd = new FourDivisors();
        int[] nums = new int[]{21, 4, 7};
        System.out.println(fd.sumFourDivisors(nums));
    }
}
