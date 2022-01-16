
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet();
        HashSet<String> visited = new HashSet();
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        Queue<String> queue = new LinkedList();
        queue.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String curr = queue.poll();
                size--;
                if (!visited.add(curr) || set.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    char c = curr.charAt(i);
                    if (c == '9') {
                        c = '0';
                    } else {
                        c += 1;
                    }
                    char[] arr = curr.toCharArray();
                    arr[i] = c;
                    String newString = new String(arr);
                    queue.add(newString);
                }

                for (int i = 0; i < 4; i++) {
                    char c = curr.charAt(i);
                    if (c == '0') {
                        c = '9';
                    } else {
                        c -= 1;
                    }
                    char[] arr = curr.toCharArray();
                    arr[i] = c;
                    String newString = new String(arr);
                    queue.add(newString);
                }

            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpentheLock otl = new OpentheLock();
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(otl.openLock(deadends, "0202"));
    }
}
