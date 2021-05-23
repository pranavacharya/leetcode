
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        int lastAdded = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == s.length() - 1) {
                return true;
            }
            int start = Math.max(lastAdded + 1, curr + minJump);
            int end = Math.min(s.length() - 1, curr + maxJump);
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    queue.add(i);
                }
                lastAdded = i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameVII jg = new JumpGameVII();
        System.out.println(jg.canReach("011010", 2, 3));
    }
}
