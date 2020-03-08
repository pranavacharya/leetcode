
public class StringWithCharactersThatHaveOddCounts {

    public String generateTheString(int n) {
        String ans = "";
        if (n == 0) {
            return ans;
        }
        int a = 97;
        if (n % 2 == 0) {
            int t = n - 1;
            while (t > 0) {
                t = t - 1;
                ans += (char) a;
            }
            ans += (char) (a + 1);
        } else {
            while (n > 0) {
                n = n - 1;
                ans += (char) a;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        StringWithCharactersThatHaveOddCounts swcthoc = new StringWithCharactersThatHaveOddCounts();
        System.out.println(swcthoc.generateTheString(0));
    }
}
