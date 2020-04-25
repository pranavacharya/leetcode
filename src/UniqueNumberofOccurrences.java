
import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberofOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int k : frequency.keySet()) {
            if (set.contains(frequency.get(k))) {
                return false;
            } else {
                set.add(frequency.get(k));
            }
        }
        return true;
    }

    public static void main(String args[]) {
        UniqueNumberofOccurrences unc = new UniqueNumberofOccurrences();
        int[] arr = new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(unc.uniqueOccurrences(arr));
    }
}
