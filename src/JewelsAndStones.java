
import java.util.HashSet;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        JewelsAndStones js = new JewelsAndStones();
        System.out.println(js.numJewelsInStones("z", "ZZ"));
    }
}
