

public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 0 && num % 2 == 0) {
            num /= 2;
        }
        while (num != 0 && num % 3 == 0) {
            num /= 3;
        }
        while (num != 0 && num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String args[]) {
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(8));
    }
}
