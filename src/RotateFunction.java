
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }

    public static void main(String args[]) {
        int[] input = {2, 6, 5, 4, -1};
        RotateFunction r = new RotateFunction();
        System.out.println(r.maxRotateFunction(input));
    }
}
