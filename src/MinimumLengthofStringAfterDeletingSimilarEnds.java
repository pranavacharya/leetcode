
public class MinimumLengthofStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            while (i + 1 < j) {
                if (s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                } else {
                    break;
                }
            }

            while (i < j - 1) {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                } else {
                    break;
                }
            }

            i++;
            j--;
        }
        return i > j ? 0 : j - i + 1;
    }

    public static void main(String args[]) {
        MinimumLengthofStringAfterDeletingSimilarEnds mlsadse = new MinimumLengthofStringAfterDeletingSimilarEnds();
        System.out.println(mlsadse.minimumLength("aabccabba"));
    }
}
