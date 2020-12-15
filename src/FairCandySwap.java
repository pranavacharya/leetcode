
import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < A.length; i++) {
            aSum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
        }

        int diff = (aSum - bSum) / 2;
        HashSet<Integer> setA = new HashSet();
        HashSet<Integer> setB = new HashSet();
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            if (setA.contains(B[i] + diff)) {
                return new int[]{B[i] + diff, B[i]};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String args[]) {
        FairCandySwap fcs = new FairCandySwap();
        int[] A = new int[]{1, 1};
        int[] B = new int[]{2, 2};
        System.out.println(Arrays.toString(fcs.fairCandySwap(A, B)));
    }
}
