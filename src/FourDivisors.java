
import java.util.HashMap;

public class FourDivisors {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                sum += map.get(num);
            } else {
                int sumLocal = countDivisor(num);
                map.put(num, sumLocal);
                sum += sumLocal;
            }
        }
        return sum;
    }

    public int countDivisor(int i) {
        int count = 2;
        int sum = 1 + i;
        int max = i;
        for (int j = 2; j < max; j++) {
            if (i % j == 0) {
                count++;
                sum += j;
                if (i / j != j) {
                    count++;
                    sum += i / j;
                }
                max = i / j;
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
