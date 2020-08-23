
import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorinaCircularTrack {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n];
        arr[rounds[0] - 1]++;
        for (int i = 0; i < rounds.length - 1; i++) {
            int x = rounds[i] - 1;
            int y = rounds[i + 1] - 1;
            if (x < y) {
                for (int j = x + 1; j <= y; j++) {
                    arr[j]++;
                }
            } else {
                for (int j = x + 1; j < n; j++) {
                    arr[j]++;
                }
                for (int j = 0; j <= y; j++) {
                    arr[j]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        MostVisitedSectorinaCircularTrack vsct = new MostVisitedSectorinaCircularTrack();
        int[] rounds = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
//        int[] rounds = new int[]{1, 3, 1, 2};
        System.out.println(vsct.mostVisited(2, rounds));
    }
}
