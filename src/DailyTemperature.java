
import java.util.Arrays;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) {
            return new int[]{};
        }
        if (T.length == 1) {
            return new int[]{0};
        }
        int[] res = new int[T.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }
        {
            for (int i = 0; i < T.length - 1; i++) {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dt = new DailyTemperature();
        System.out.println(Arrays.toString(dt.dailyTemperatures(input)));
    }

}
