
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberofStudentsUnabletoEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack();
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < students.length; i++) {
            queue.add(students[i]);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.add(sandwiches[i]);
        }
        int steps = 0;
        while (true) {
            if (steps == queue.size()) {
                break;
            }
            if (stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
                steps = 0;
            } else {
                queue.add(queue.poll());
                steps++;
            }
        }
        return queue.size();
    }

    public static void main(String args[]) {
        NumberofStudentsUnabletoEatLunch nsuel = new NumberofStudentsUnabletoEatLunch();
        int[] students = new int[]{1, 1, 1, 0, 0, 1};
        int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        System.out.println(nsuel.countStudents(students, sandwiches));
    }
}
