
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                int current = asteroids[i];
                if (current < 0 && stack.peek() < 0 || current > 0 && stack.peek() > 0
                        || current > 0 && stack.peek() < 0) {
                    stack.add(current);
                } else {
                    boolean destroyed = false;
                    while (!stack.isEmpty() && current < 0 && stack.peek() > 0) {
                        if (Math.abs(current) >= Math.abs(stack.peek())) {
                            int last = stack.pop();
                            if (Math.abs(last) == Math.abs(current)) {
                                destroyed = true;
                                break;
                            }
                        } else {
                            destroyed = true;
                            break;
                        }
                    }
                    if (!destroyed) {
                        stack.add(current);
                    }
                }
            }
        }
        list.addAll(stack);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        AsteroidCollision ac = new AsteroidCollision();
//        int[] asteroids = new int[]{-2, -2, 1, -2};
        int[] asteroids = new int[]{10, 2, -5};
        System.out.println(Arrays.toString(ac.asteroidCollision(asteroids)));
    }
}
