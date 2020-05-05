
import java.util.ArrayList;

public class Maximum69Number {

    public int maximum69Number(int num) {
        ArrayList<Integer> digits = new ArrayList();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        System.out.println(digits);
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) == 6) {
                digits.set(i, 9);
                break;
            }
        }
        int ans = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            ans = ans * 10 + digits.get(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        Maximum69Number m69n = new Maximum69Number();
        System.out.println(m69n.maximum69Number(9696));
    }
}
