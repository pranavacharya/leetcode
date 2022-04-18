
import java.util.HashMap;

public class MinimumRoundstoCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int min = 0;

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count == 1) {
                return -1; 
            }
            int two = count / 2;
            int three = count / 3;
            if(count % 3 == 2) {
                three++;
            } else if(count % 3 == 1) {
                three++;
            }
            min += Math.min(two, three);
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumRoundstoCompleteAllTasks mrcat = new MinimumRoundstoCompleteAllTasks();
        int[] tasks = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(mrcat.minimumRounds(tasks));
    }
}
