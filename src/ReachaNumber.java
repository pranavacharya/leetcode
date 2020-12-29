
import java.util.LinkedList;
import java.util.Queue;

public class ReachaNumber {

    public int reachNumber(int target) {
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.poll();
                if (curr == target) {
                    return step - 1;
                }
                queue.add(curr + step);

                queue.add(curr - step);

                size--;
            }
            step++;
        }
        return step;
    }

    public static void main(String args[]) {
        ReachaNumber rn = new ReachaNumber();
        System.out.println(rn.reachNumber(2));
        System.out.println(rn.reachNumber(3));
    }
}
