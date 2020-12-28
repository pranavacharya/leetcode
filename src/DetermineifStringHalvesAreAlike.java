
import java.util.HashSet;

public class DetermineifStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        HashSet<Character> set = new HashSet();
        int count = 0;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String args[]) {
        DetermineifStringHalvesAreAlike disha = new DetermineifStringHalvesAreAlike();
        System.out.println(disha.halvesAreAlike("textbook"));
        System.out.println(disha.halvesAreAlike("AbCdEfGh"));
    }
}
