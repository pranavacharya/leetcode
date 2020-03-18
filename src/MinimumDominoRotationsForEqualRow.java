
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        int min = Math.min(setOneRow(A, B), setOneRow(B, A));
        min = min == Integer.MAX_VALUE ? -1 : min;
        return min;
    }

    public int setOneRow(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int rotations = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == i) {
                    continue;
                } else if (B[j] == i) {
                    rotations++;
                    continue;
                } else {
                    rotations = Integer.MAX_VALUE;
                    break;
                }
            }
            min = Math.min(min, rotations);
        }
        return min;
    }

    public static void main(String args[]) {
        MinimumDominoRotationsForEqualRow mdrfer = new MinimumDominoRotationsForEqualRow();
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(mdrfer.minDominoRotations(A, B));
    }
}
