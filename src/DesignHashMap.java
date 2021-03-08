
import java.util.ArrayList;

public class DesignHashMap {

    /**
     * Initialize your data structure here.
     */
    private ArrayList<int[]>[] map;

    public DesignHashMap() {
        this.map = new ArrayList[1000000];
        for (int i = 0; i < this.map.length; i++) {
            this.map[i] = new ArrayList();
        }
    }

    private int calculateHashCode(int key) {
        return key % 1000000;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashcode = calculateHashCode(key);
        if (get(key) != -1) {
            remove(key);
        }
        this.map[hashcode].add(new int[]{key, value});
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int hashcode = calculateHashCode(key);
        for (int i = 0; i < this.map[hashcode].size(); i++) {

            if (key == this.map[hashcode].get(i)[0]) {
                return this.map[hashcode].get(i)[1];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a
     * mapping for the key
     */
    public void remove(int key) {
        int hashcode = calculateHashCode(key);
        for (int i = 0; i < this.map[hashcode].size(); i++) {
            if (key == this.map[hashcode].get(i)[0]) {
                this.map[hashcode].remove(i);
            }
        }
    }

    public static void main(String args[]) {
        DesignHashMap dhm = new DesignHashMap();
        dhm.put(1, 2);
        System.out.println(dhm.get(1));
        dhm.remove(1);
        System.out.println(dhm.get(1));
    }
}
