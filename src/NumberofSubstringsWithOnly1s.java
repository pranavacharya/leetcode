
public class NumberofSubstringsWithOnly1s {

    private long mod = 1000000007;

    public int numSub(String s) {
        int count = 0;
        char[] ip = s.toCharArray();
        int start = 0;
        int end = 0;
        while (start < ip.length) {
            while (start < ip.length && ip[start] != '1') {
                start++;
            }
            end = start;
            while (end < ip.length && ip[end] == '1') {
                end++;
            }
            int length = end - start;
            long val = ((length % mod * (length + 1) % mod) % mod) / 2;
            count = (int) (((count % mod) + (val % mod)) % mod);
            start = end + 1;
        }
        return count;
    }

    public static void main(String args[]) {
        NumberofSubstringsWithOnly1s nosw1 = new NumberofSubstringsWithOnly1s();
        System.out.println(nosw1.numSub("0110111"));
    }
}
