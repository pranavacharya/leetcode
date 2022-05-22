
import java.util.HashMap;


public class PercentageofLetterinString {
    public int percentageLetter(String s, char letter) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map.getOrDefault(letter, 0) * 100 / s.length() ;
    }
        
    public static void main(String[] args) {
        PercentageofLetterinString pls = new PercentageofLetterinString();
        System.out.println(pls.percentageLetter("foobar", 'o'));
    }
}
