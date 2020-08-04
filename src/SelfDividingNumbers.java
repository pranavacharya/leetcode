
import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int n = i;
            while (n > 0) {
                int digit = n % 10;
                if (digit == 0 || i % digit != 0) {
                    flag = false;
                    break;
                }
                n = n / 10;
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        SelfDividingNumbers sdn = new SelfDividingNumbers();
        System.out.println(sdn.selfDividingNumbers(1, 22));
    }
}
