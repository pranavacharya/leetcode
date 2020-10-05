
public class ComplementofBase10Integer {

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int len = (int) (Math.log(N) / Math.log(2)) + 1;
        for (int i = 0; i < len; i++) {
            N = N ^ (1 << i);
        }
        return N;
    }

    public static void main(String args[]) {
        ComplementofBase10Integer cbi = new ComplementofBase10Integer();
        System.out.println(cbi.bitwiseComplement(5));
        System.out.println(cbi.bitwiseComplement(7));
        System.out.println(cbi.bitwiseComplement(10));
        System.out.println(cbi.bitwiseComplement(0));
    }
}
