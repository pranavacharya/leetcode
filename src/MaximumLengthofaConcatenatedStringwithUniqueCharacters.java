
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {

    private int max = Integer.MIN_VALUE;

    public int maxLength(List<String> arr) {
        subset("", new ArrayList(arr));
        return this.max;
    }

    public void subset(String soFar, ArrayList rem) {
        if (rem.isEmpty()) {
            this.max = this.max > soFar.length() ? this.max : soFar.length();
        } else {
            String left = soFar;
            ArrayList right = new ArrayList(rem);
            String add = right.remove(0).toString();
            subset(left, right);
            if (isUnique(add) && ifNotContainsChar(add, left)) {
                left = left.concat(add);
                subset(left, right);
            }
        }
    }

    public boolean isUnique(String a) {
        HashSet<Character> set = new HashSet<>();
        for (char c : a.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    public boolean ifNotContainsChar(String a, String b) {
        HashSet<Character> set = new HashSet<>();
        for (char c : a.toCharArray()) {
            set.add(c);
        }
        for (char c : b.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        MaximumLengthofaConcatenatedStringwithUniqueCharacters mlcsuc = new MaximumLengthofaConcatenatedStringwithUniqueCharacters();
        ArrayList<String> arr = new ArrayList();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(mlcsuc.maxLength(arr));
    }
}
