
import java.util.HashMap;

public class CountLargestGroup {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> size = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int ans = sumOfDigit(i);
            size.put(ans, size.getOrDefault(ans, 0) + 1);
            max = Math.max(max, size.get(ans));
        }
        int result = 0;
        for (int i : size.keySet()) {
            if (size.get(i) == max) {
                result++;
            }
        }
        return result;
    }

    public int sumOfDigit(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        map.put(n, sum);
        return sum;
    }

    public static void main(String args[]) {
        CountLargestGroup clg = new CountLargestGroup();
        System.out.println(clg.countLargestGroup(2));
    }
}
