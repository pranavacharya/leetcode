
public class CalculateMoneyinLeetcodeBank {

    public int totalMoney(int n) {
        if (n <= 7) {
            return n * (n + 1) / 2;
        }

        int weeks = n / 7;
        int ans = 0;
        ans = weeks * 28;
        int val = 1;
        while (weeks > 1) {
            ans += 7 * val;
            val++;
            weeks--;
        }
        int days = n % 7;
        ans += days * (days + 1) / 2;
        ans += val * days;
        return ans;
    }

    public static void main(String args[]) {
        CalculateMoneyinLeetcodeBank cmilb = new CalculateMoneyinLeetcodeBank();
        System.out.println(cmilb.totalMoney(4));
    }
}
