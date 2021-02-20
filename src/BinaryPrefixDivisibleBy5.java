
import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = num << 1;
            num = num | A[i];
            num = num % 5;
            list.add(num == 0);
        }
        return list;
    }

    public static void main(String args[]) {
        BinaryPrefixDivisibleBy5 bpdb5 = new BinaryPrefixDivisibleBy5();
        int[] A = new int[]{0, 1, 1};
        System.out.println(bpdb5.prefixesDivBy5(A));
    }
}
