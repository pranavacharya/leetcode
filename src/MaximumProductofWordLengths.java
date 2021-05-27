
import java.util.HashSet;

public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                char[] arr1 = words[i].toCharArray();
                char[] arr2 = words[j].toCharArray();
                HashSet<Character> set = new HashSet();
                for (int k = 0; k < arr1.length; k++) {
                    set.add(arr1[k]);
                }
                boolean flag = true;
                for (int k = 0; k < arr2.length; k++) {
                    if (set.contains(arr2[k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count = Math.max(count, arr1.length * arr2.length);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumProductofWordLengths mpwl = new MaximumProductofWordLengths();
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(mpwl.maxProduct(words));
    }
}
