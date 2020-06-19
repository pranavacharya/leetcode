
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num != i) {
                    sum += i;
                }
                if (i * i != num && i != 1) {
                    sum += (num / i);
                }
            }
        }
        return num == sum;
    }

    public static void main(String args[]) {
        PerfectNumber pn = new PerfectNumber();
        System.out.println(pn.checkPerfectNumber(1));
    }
}
