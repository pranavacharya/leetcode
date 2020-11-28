
public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        int len = word.length();
        int count = 0;
        int continous = 0;
        for (int i = 0; i + len <= sequence.length();) {
            String sb = sequence.substring(i, i + len);
            if (sb.equals(word)) {
                continous++;
                i = i + len;
            } else {
                count = Math.max(count, continous);
                continous = 0;
                i++;
            }
        }
        count = Math.max(count, continous);
        return count;
    }

    public static void main(String args[]) {
        MaximumRepeatingSubstring mrs = new MaximumRepeatingSubstring();
        System.out.println(mrs.maxRepeating("ababc", "ab"));
        System.out.println(mrs.maxRepeating("a", "a"));
    }
}
