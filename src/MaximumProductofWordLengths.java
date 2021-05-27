
public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int count = 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask = mask | 1 << (word.charAt(j) - 'a');
            }
            masks[i] = mask;
        }
        for (int i = 0; i < masks.length; i++) {
            for (int j = i + 1; j < masks.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    count = Math.max(count, words[i].length() * words[j].length());
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
