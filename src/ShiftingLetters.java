
public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i + 1] % 26) + (shifts[i] % 26);
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ((char) (arr[i] + (shifts[i] % 26)) > 'z') {
                arr[i] = (char) ('a' + (arr[i] + (shifts[i] % 26)) - 'z' - 1);
            } else {
                arr[i] = (char) (arr[i] + (shifts[i] % 26));
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        int[] shifts = new int[]{10, 20, 30};
        System.out.println(sl.shiftingLetters("bad", shifts));
    }
}
