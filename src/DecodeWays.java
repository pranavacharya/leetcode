
public class DecodeWays {

    public int numDecodings(String s) {
        int res = 0;
        int[] mem = new int[s.length() + 1];
        res = decode(s, s.length(), mem);
        return res;
    }

    public int decode(String ip, int k, int[] mem) {
        if (k == 0) {
            return 1;
        }
        int l = ip.length() - k;
        if (ip.charAt(l) == '0') {
            return 0;
        }
        int ans = 0;
        if (mem[k] != 0) {
            return mem[k];
        }
        ans = decode(ip, k - 1, mem);
        if (k >= 2 && Integer.valueOf(ip.substring(l, l + 2)) <= 26) {
            ans = ans + decode(ip, k - 2, mem);
        }
        mem[k] = ans;
        return ans;
    }

    public static void main(String args[]) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("22"));
    }
}
