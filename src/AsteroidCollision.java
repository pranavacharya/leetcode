
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.add(asteroids[i]);
                continue;
            }
            if (asteroids[i] < 0 && stack.peek() > 0) {
                boolean status = false;
                while (!stack.isEmpty() && stack.peek() > 0 && (stack.peek() <= Math.abs(asteroids[i]))) {
                    int lastrem = stack.pop();
                    status = lastrem == Math.abs(asteroids[i]);
                    if (status) {
                        break;
                    }
                }
                if ((stack.isEmpty() && !status) || (!stack.isEmpty() && stack.peek() < 0 && !status)) {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        int[] res = new int[list.size()];
        int index = list.size() - 1;
        for (int i : list) {
            res[index] = i;
            index--;
        }
        return res;
    }

    public static void main(String args[]) {
        AsteroidCollision ac = new AsteroidCollision();
        int[] asteroids = new int[]{-2, -1, 1, -1};
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids)));
    }
}
