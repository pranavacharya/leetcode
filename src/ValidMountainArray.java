
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }

    public static void main(String args[]) {
        ValidMountainArray vma = new ValidMountainArray();
        int[] A = new int[]{1, 2, 3, 4, 4, 3, 2};
        System.out.println(vma.validMountainArray(A));
    }
}
