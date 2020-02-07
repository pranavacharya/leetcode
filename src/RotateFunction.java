
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum = sum + (A[((i + j) % A.length)] * j);
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

    public static void main(String args[]) {
        int[] input = {-1, -1};
        RotateFunction r = new RotateFunction();
        System.out.println(r.maxRotateFunction(input));
    }
}
