
public class FairDistributionofCookies {

    public int distributeCookies(int[] cookies, int k) {
        this.max = Integer.MAX_VALUE;
        helper(cookies, k, new int[k + 1], 0);
        return this.max;
    }

    private int max;

    private void helper(int[] cookies, int k, int[] values, int index) {
        if (index == cookies.length) {
            int localmax = 0;
            for (int i = 0; i < values.length; i++) {
                localmax = Math.max(localmax, values[i]);
            }
            this.max = Math.min(this.max, localmax);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (cookies[index] == 0) {
                continue;
            }
            int cookie = cookies[index];
            values[i] += cookie;
            cookies[index] = 0;
            helper(cookies, k, values, index + 1);
            values[i] -= cookie;
            cookies[index] = cookie;
        }

    }

    public static void main(String[] args) {
        FairDistributionofCookies fdc = new FairDistributionofCookies();
        int[] cookies = new int[]{8, 15, 10, 20, 8};
        System.out.println(fdc.distributeCookies(cookies, 2));
    }
}
