
import java.util.Arrays;

public class EliminateMaximumNumberofMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i] = (double) dist[i] / (double) speed[i];
        }

        Arrays.sort(time);

        for (int i = 0; i < time.length; i++) {
            if (i >= time[i]) {
                return i;
            }
        }

        return time.length;

    }

    public static void main(String[] args) {
        EliminateMaximumNumberofMonsters emnm = new EliminateMaximumNumberofMonsters();
        int[] dist = new int[]{1, 3, 4};
        int[] speed = new int[]{1, 1, 1};
        System.out.println(emnm.eliminateMaximum(dist, speed));
    }
}
