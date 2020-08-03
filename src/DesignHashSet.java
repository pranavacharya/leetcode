
import java.util.ArrayList;

public class DesignHashSet {

    private ArrayList<Integer>[] buckets;
    private int size;

    public DesignHashSet() {
        this.size = 1000;
        this.buckets = new ArrayList[this.size];
        for (int i = 0; i < this.buckets.length; i++) {
            buckets[i] = new ArrayList();
        }
    }

    private int findHash(int key) {
        return key % this.size;
    }

    public void add(int key) {
        int index = findHash(key);
        ArrayList<Integer> list = this.buckets[index];
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = findHash(key);
        ArrayList<Integer> list = this.buckets[index];
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = findHash(key);
        ArrayList<Integer> list = this.buckets[index];
        return list.contains(key);
    }

    public static void main(String args[]) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }
}
