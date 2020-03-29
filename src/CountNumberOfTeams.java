
import java.util.ArrayList;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int count = subset(rating, 0, new ArrayList<Integer>(), 0);
        return count;
    }

    public int subset(int[] rating, int index, ArrayList<Integer> soFar, int count) {
        if (soFar.size() == 3 && isMonotonic(soFar)) {
            count++;
        }
        if (soFar.size() == 3) {
            return count;
        }
        if (index >= rating.length) {
            return count;
        } else {
            soFar.add(rating[index]);
            count = subset(rating, index + 1, new ArrayList(soFar), count);
            soFar.remove(soFar.size() - 1);
            count = subset(rating, index + 1, new ArrayList(soFar), count);
            return count;
        }
    }

    public boolean isMonotonic(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                increasing = false;
            }
            if (arr[i] < arr[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String args[]) {
        CountNumberOfTeams cnt = new CountNumberOfTeams();
        int[] rating = new int[]{2, 5, 3, 4, 1};
        System.out.println(cnt.numTeams(rating));
    }
}
