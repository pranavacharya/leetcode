
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < 10; i++) {
            dfs(result, low, high, i, i);
        }
        Collections.sort(result);
        return result;
    }

    public void dfs(List<Integer> result, int low, int high, int number, int lastDigit) {
        if (number >= low && number <= high && !result.contains(number)) {
            result.add(number);
        }
        if (lastDigit + 1 < 10 && number <= high) {
            int newNum = number * 10 + lastDigit + 1;
            int ld = newNum % 10;
            dfs(result, low, high, newNum, ld);
        }
    }

    public static void main(String args[]) {
        SequentialDigits sd = new SequentialDigits();
        System.out.println(sd.sequentialDigits(1000, 13000));
    }
}
