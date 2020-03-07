
import java.util.HashSet;

public class LongestSubstringWithEvenVowels {

    private HashSet<Character> set;
    private int a;
    private int e;
    private int i;
    private int o;
    private int u;

    public LongestSubstringWithEvenVowels() {
        set = new HashSet<>();
        this.set.add('a');
        this.set.add('e');
        this.set.add('i');
        this.set.add('o');
        this.set.add('u');
        a = 0;
        e = 0;
        i = 0;
        o = 0;
        u = 0;
    }

    public int findTheLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if(hasEvenVowels(temp)) {
                    max = (max > temp.length()) ? max : temp.length();
                }
            }
        }
        return max;
    }

    public boolean hasEvenVowels(String ip) {
        char[] charArr = ip.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (this.set.contains(charArr[i])) {
                switch (charArr[i]) {
                    case 'a':
                        this.a++;
                        break;
                    case 'e':
                        this.e++;
                        break;
                    case 'i':
                        this.i++;
                        break;
                    case 'o':
                        this.o++;
                        break;
                    case 'u':
                        this.u++;
                        break;
                    default:
                        break;
                }
            }
        }
        boolean ans = this.a % 2 == 0 && this.e % 2 == 0 && this.i % 2 == 0 && this.o % 2 == 0 && this.u % 2 == 0;
        this.a = 0;
        this.e = 0;
        this.i = 0;
        this.o = 0;
        this.u = 0;
        return ans;
    }

    public static void main(String args[]) {
        LongestSubstringWithEvenVowels lswev = new LongestSubstringWithEvenVowels();
        String input = "eleetminicoworoep";
        System.out.println(lswev.findTheLongestSubstring(input));
    }
}
