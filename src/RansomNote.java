
import java.util.HashMap;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomFrequency = new HashMap<>();
        HashMap<Character, Integer> magazineFrequency = new HashMap<>();

        for (char i : ransomNote.toCharArray()) {
            ransomFrequency.put(i, ransomFrequency.getOrDefault(i, 0) + 1);
        }

        for (char i : magazine.toCharArray()) {
            magazineFrequency.put(i, magazineFrequency.getOrDefault(i, 0) + 1);
        }

        for (char key : ransomFrequency.keySet()) {
            if (magazineFrequency.containsKey(key)) {
                if (ransomFrequency.get(key) > magazineFrequency.get(key)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aca", "baa"));
    }
}
