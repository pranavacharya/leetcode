
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int i = 0;
        int j = i + 1;
        int ans = 0;
        while (j < A.length) {
            int diff = A[j] - A[i];
            while (j + 1 < A.length && A[j + 1] - A[j] == diff) {
                j++;
            }

            int count = j - i;
            if (count >= 2) {
                int local = (count * (count - 1)) / 2;
                ans += local;
            }
            i = j;
            j = i + 1;
        }

        return ans;
    }

    public static void main(String args[]) {
        ArithmeticSlices as = new ArithmeticSlices();
        int[] A = new int[]{1, 2, 3};
        System.out.println(as.numberOfArithmeticSlices(A));
    }
}
