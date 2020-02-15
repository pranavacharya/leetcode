
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DailyTemperature {

    public class obj {

        private int data;
        private int index;

        public obj(int data, int index) {
            this.data = data;
            this.index = index;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<obj> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (stk.empty() || T[i] < stk.peek().getData()) {
                stk.push(new obj(T[i], i));
            } else {
                obj top = stk.peek();
                while (top.getData() < T[i]) {
                    map.put(top.getIndex(), i);
                    stk.pop();
                    if (!stk.empty()) {
                        top = stk.peek();
                    } else {
                        break;
                    }
                }
                stk.push(new obj(T[i], i));
            }
        }
        for (int i = 0; i < T.length; i++) {
            if (map.containsKey(i)) {
                res[i] = map.get(i) - i;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dt = new DailyTemperature();
        System.out.println(Arrays.toString(dt.dailyTemperatures(input)));
    }

}
