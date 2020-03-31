
public class NumberComplement {

    public int findComplement(int num) {
        int x = (int) (Math.log(num)
                / Math.log(2)) + 1;
        for (int i = 0; i < x; i++) {
            num = (num ^ (1 << i));
        }
        return num;
    }

    public static void main(String args[]) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(5));
    }
}
