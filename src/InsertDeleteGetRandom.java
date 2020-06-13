
import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;

    public InsertDeleteGetRandom() {
        this.list = new ArrayList();
        this.map = new HashMap();
    }

    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        } else {
            this.list.add(val);
            this.map.put(val, this.list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        } else {
            int index = this.map.get(val);
            int lastElement = this.list.get(this.list.size() - 1);
            this.list.set(index, lastElement);
            this.map.put(lastElement, index);
            this.map.remove(val);
            this.list.remove(this.list.size() - 1);
            return true;
        }
    }

    public int getRandom() {
        return this.list.get((int) (Math.random() * this.list.size()));
    }

}
