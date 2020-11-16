
public class LongestMountaininArray {

    public int longestMountain(int[] A) {
        int max = 0;
        int index = 0;
        while (index < A.length - 1) {
            int start = index;
            while (index + 1 < A.length && A[index] < A[index + 1]) {
                index++;
            }
            boolean down = false;
            while (start != index && index + 1 < A.length && A[index + 1] < A[index]) {
                index++;
                down = true;
            }
            int end = index;
            int dist = (end != start && down) ? end - start + 1 : 0;
            max = Math.max(max, dist);
            if (end == start) {
                index++;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestMountaininArray lma = new LongestMountaininArray();
        int[] A = new int[]{2, 1, 4, 7, 3, 2, 5};
        System.out.println(lma.longestMountain(A));
    }
}
