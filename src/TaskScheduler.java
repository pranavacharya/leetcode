import java.util.HashMap;

public class TaskScheduler {

    private HashMap<String, Integer> dp = new HashMap<>();
    private int least;

    public int leastInterval(char[] tasks, int n) {
        this.least = Integer.MAX_VALUE;
        permute("", new String(tasks), n);
        return this.least;
    }

    public void permute(String soFar, String rem, int n) {
        if (rem.isEmpty()) {
            int cost;
            if (this.dp.containsKey(soFar)) {
                cost = this.dp.get(soFar);
            } else {
                cost = calulateCost(soFar, n);
                this.dp.put(soFar, cost);
            }
            this.least = Math.min(cost, this.least);
        } else {
            for (int i = 0; i < rem.length(); i++) {
                String letter = rem.substring(i, i + 1);
                String before = rem.substring(0, i);
                String after = rem.substring(i + 1);
                permute(soFar.concat(letter), before.concat(after), n);
            }
        }
    }

    public int calulateCost(String combination, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cost = 0;
        int diff;
        char[] input = combination.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                if (i - map.get(input[i]) <= n) {
                    diff = n + 1 - (i - map.get(input[i]));
                    for (char name : map.keySet()) {
                        map.put(name, map.get(name) - diff);
                    }
                    cost = cost + diff;
                    map.put(input[i], i);
                } else {
                    map.put(input[i], i);
                }
            } else {
                map.put(input[i], i);
            }
            cost++;
        }
        return cost;
    }

    public static void main(String args[]) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};  // 16 (3 min 39 sec)
        System.out.println(ts.leastInterval(tasks, 2));
    }
}

