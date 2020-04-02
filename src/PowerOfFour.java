
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int len = (int) (Math.log(num) / Math.log(2)) + 1;
        int bit = 0;
        int mask = 1;
        while (len > 0) {
            if ((num & mask) != 0) {
                bit++;
            }
            mask = mask << 1;
            len--;
        }
        if (bit > 1) {
            return false;
        }
        len = (int) (Math.log(num) / Math.log(2)) + 1;
        mask = 10;
        if ((num & 1) != 0) {
            return false;
        } else {
            while (len > 0) {
                if ((num & mask) != 0) {
                    return false;
                }
                mask = mask << 2;
                len--;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        PowerOfFour pf = new PowerOfFour();
        System.out.println(pf.isPowerOfFour(20));
    }
}
