
import java.util.HashMap;

public class MaximumNumberofBallsinaBox {

    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap();
        int maxvalue = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = sumOfDigits(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.get(sum) > maxvalue) {
                maxvalue = map.get(sum);
            }
        }
        return maxvalue;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        MaximumNumberofBallsinaBox mnbb = new MaximumNumberofBallsinaBox();
        System.out.println(mnbb.countBalls(1, 10));
    }
}
