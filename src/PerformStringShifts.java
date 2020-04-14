
public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        char[] strarr = s.toCharArray();
        for (int[] arr : shift) {
            int direction = arr[0];
            int amount = arr[1];
            if (direction == 0) {
                while (amount > 0) {
                    char first = strarr[0];
                    for (int i = 0; i < strarr.length - 1; i++) {
                        strarr[i] = strarr[i + 1];
                    }
                    strarr[strarr.length - 1] = first;
                    amount--;
                }
            } else {
                while (amount > 0) {
                    char last = strarr[strarr.length - 1];
                    for (int i = strarr.length - 1; i > 0; i--) {
                        strarr[i] = strarr[i - 1];
                    }
                    strarr[0] = last;
                    amount--;
                }
            }

        }
        return String.valueOf(strarr);
    }

    public static void main(String args[]) {
        PerformStringShifts fss = new PerformStringShifts();
        int[][] shift = new int[][]{{0, 1}, {1, 2}};
        System.out.println(fss.stringShift("abc", shift));
    }
}
