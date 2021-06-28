
public class NumberofWonderfulSubstrings {

    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        count[0] = 1;
        long ans = 0;
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            mask ^= (1 << c);
            ans += count[mask];
            for (int j = 0; j < 10; j++) {
                int newMask = mask ^ (1 << j);
                ans += count[newMask];
            }
            count[mask]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberofWonderfulSubstrings nws = new NumberofWonderfulSubstrings();
        System.out.println(nws.wonderfulSubstrings("aba"));
    }
}
