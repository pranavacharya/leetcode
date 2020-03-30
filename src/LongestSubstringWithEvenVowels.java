
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
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for(int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j ++){
                dp[i] = Math.max(dp[i],Math.max(dp[j], LengthStringWithEvenVowels(s.substring(j, i))));
            }
        }
        return dp[s.length()];
    }

    public int LengthStringWithEvenVowels(String ip) {
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
        if(this.a % 2 == 0 && this.e % 2 == 0 && this.i % 2 == 0 && this.o % 2 == 0 && this.u % 2 == 0){
            this.a = 0;
            this.e = 0;
            this.i = 0;
            this.o = 0;
            this.u = 0;
            return ip.length();
        } else{
            this.a = 0;
            this.e = 0;
            this.i = 0;
            this.o = 0;
            this.u = 0;
            return 0;
        }
    }
    public static void main(String args[]) {
        LongestSubstringWithEvenVowels lswev = new LongestSubstringWithEvenVowels();
        String input = "eleetminicoworoep";
        System.out.println(lswev.findTheLongestSubstring(input));
    }
}
