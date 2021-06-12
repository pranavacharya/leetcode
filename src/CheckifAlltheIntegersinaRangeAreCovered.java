
public class CheckifAlltheIntegersinaRangeAreCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[51];
        for (int i = 0; i < ranges.length; i++) {

            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                arr[j]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CheckifAlltheIntegersinaRangeAreCovered cairc = new CheckifAlltheIntegersinaRangeAreCovered();
        int[][] ranges = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println(cairc.isCovered(ranges, 2, 5));
    }
}
