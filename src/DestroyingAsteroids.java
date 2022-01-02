
import java.util.TreeMap;

public class DestroyingAsteroids {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        TreeMap<Long, Integer> treemap = new TreeMap();
        for (int i = 0; i < asteroids.length; i++) {
            treemap.put((long) asteroids[i], treemap.getOrDefault((long) asteroids[i], 0) + 1);
        }
        int left = asteroids.length;
        long cmass = mass;
        while (left > 0) {
            Long key = treemap.floorKey(cmass);
            if (key == null) {
                return false;
            } else {
                treemap.put(key, treemap.get(key) - 1);
                if (treemap.get(key) == 0) {
                    treemap.remove(key);
                }
                cmass += key;
            }
            left--;
        }
        return true;
    }

    public static void main(String[] args) {
        DestroyingAsteroids da = new DestroyingAsteroids();
        int[] asteroids = new int[]{4, 9, 23, 4};
        System.out.println(da.asteroidsDestroyed(5, asteroids));
    }
}
