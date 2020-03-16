
import java.util.HashMap;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineFrequency = new HashMap<>();
        for (char i : magazine.toCharArray()) {
            magazineFrequency.put(i, magazineFrequency.getOrDefault(i, 0) + 1);
        }

        for (char key : ransomNote.toCharArray()) {
            if (magazineFrequency.containsKey(key)) {
                if (magazineFrequency.get(key) <= 0) {
                    return false;
                } else {
                    magazineFrequency.put(key, magazineFrequency.get(key) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aa", "baa"));
    }
}
