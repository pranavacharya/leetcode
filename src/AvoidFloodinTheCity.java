
import java.util.ArrayList;
import java.util.Arrays;

public class AvoidFloodinTheCity {

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (list.contains("" + rains[i])) {
                    return new int[]{};
                } else {
                    list.add("" + rains[i]);
                    ans[i] = -1;
                }
            } else {
                boolean status = true;
                for (int j = i + 1; j < rains.length; j++) {
                    if (list.contains("" + rains[j])) {
                        list.remove("" + rains[j]);
                        ans[i] = rains[j];
                        status = false;
                        break;
                    }
                }
                if (status) {
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        AvoidFloodinTheCity afic = new AvoidFloodinTheCity();
        int[] rains = new int[]{1, 2, 0, 0, 2, 1};
        System.out.println(Arrays.toString(afic.avoidFlood(rains)));
    }
}
