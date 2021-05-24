
public class DeleteColumnstoMakeSorted {

    public int minDeletionSize(String[] strs) {
        char[][] arr = new char[strs.length][];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = strs[i].toCharArray();
            max = Math.max(max, arr[i].length);
        }
        int count = 0;

        for (int j = 0; j < max; j++) {
            for (int i = 1; i < arr.length; i++) {
                if (j >= arr[i].length) {
                    continue;
                }
                if (arr[i][j] < arr[i - 1][j]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        DeleteColumnstoMakeSorted dcms = new DeleteColumnstoMakeSorted();
        String[] strs = new String[]{"cba", "daf", "ghi"};
        System.out.println(dcms.minDeletionSize(strs));
    }
}
