
import java.util.HashSet;

public class DetermineifStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
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
