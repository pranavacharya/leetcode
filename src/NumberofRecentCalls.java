
import java.util.TreeMap;

public class NumberofRecentCalls {

    private TreeMap<Integer, Integer> map;
    private int lastKey;

    public NumberofRecentCalls() {
        this.map = new TreeMap();
        this.lastKey = -1;
    }

    public int ping(int t) {
        if (this.lastKey == -1) {
            map.put(t, 1);
            this.lastKey = t;
            return 1;
        }
        int begin = t - 3000;
        Integer key = this.map.ceilingKey(begin);
        int minus = 0;
        if (key != null) {
            minus = this.map.get(key) - 1;
            int total = this.map.get(this.lastKey);
            this.map.put(t, total + 1);
            this.lastKey = t;
            return total + 1 - minus;
        } else {
            this.lastKey = t;
            this.map.put(t, 1);
            return 1;
        }
    }

    public static void main(String args[]) {
        NumberofRecentCalls ncr = new NumberofRecentCalls();
        System.out.println(ncr.ping(1));
        System.out.println(ncr.ping(100));
        System.out.println(ncr.ping(3001));
        System.out.println(ncr.ping(3002));
    }
}
