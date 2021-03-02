
public class CountNumberofHomogenousSubstrings {

    int mod = (int) (1e9 + 7);

    public int countHomogenous(String s) {
        long count = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            while (j + 1 < s.length() && s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            count = ((count % mod) + (findCombination(j - i + 1) % mod)) % mod;
            j++;
            i = j;
        }
        return (int) count;
    }

    private long findCombination(long n) {
        long mul = n * (n + 1);
        return mul / 2L;
    }

    public static void main(String args[]) {
        CountNumberofHomogenousSubstrings cnhs = new CountNumberofHomogenousSubstrings();
        System.out.println(cnhs.countHomogenous("abbcccaa"));
    }
}
