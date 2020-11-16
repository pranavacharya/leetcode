
public class LongestMountaininArray {

    public int longestMountain(int[] A) {
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            max = Math.max(max, expandFromCenter(i, A));
        }
        return max;
    }

    private int expandFromCenter(int index, int[] A) {
        int i = index, j = index;
        while (i - 1 >= 0 && A[i] > A[i - 1]) {
            i--;
        }
        while (j + 1 < A.length && A[j] > A[j + 1]) {
            j++;
        }
        if (i == index || j == index) {
            return 0;
        }
        return i != j ? j - i + 1 : 0;
    }

    public static void main(String args[]) {
        LongestMountaininArray lma = new LongestMountaininArray();
        int[] A = new int[]{2, 1, 4, 7, 3, 2, 5};
        System.out.println(lma.longestMountain(A));
    }
}
