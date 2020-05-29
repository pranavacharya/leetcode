
public class LongestMountaininArray {

    public int longestMountain(int[] A) {
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                max = Math.max(max, calculateWidth(A, i));
            }
        }
        return max;
    }

    private int calculateWidth(int[] A, int index) {
        int width = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (A[i] >= A[i + 1]) {
                break;
            }
            width++;
        }
        for (int i = index + 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                break;
            }
            width++;
        }
        return width;
    }

    public static void main(String args[]) {
        LongestMountaininArray lma = new LongestMountaininArray();
        int[] A = new int[]{2, 1, 4, 7, 3, 2, 5};
        System.out.println(lma.longestMountain(A));
    }
}
