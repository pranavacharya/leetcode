
public class NumberComplement {

    public int findComplement(int num) {
        int mask = 1;
        int bits = (int) (Math.log(num)
                / Math.log(2)) + 1;
        while (bits > 0) {
            num = num ^ mask;
            mask = mask << 1;
            bits--;
        }
        return num;
    }

    public static void main(String args[]) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(2147483647));
    }
}
