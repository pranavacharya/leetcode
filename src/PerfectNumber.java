
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }

    public static void main(String args[]) {
        PerfectNumber pn = new PerfectNumber();
        System.out.println(pn.checkPerfectNumber(29));
    }
}
