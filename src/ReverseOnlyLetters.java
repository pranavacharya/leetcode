
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j) {
                if (Integer.valueOf(arr[i]) < 65) {
                    i++;
                } else if ((Integer.valueOf(arr[i]) > 90)
                        && (Integer.valueOf(arr[i]) < 97)) {
                    i++;
                } else if (Integer.valueOf(arr[i]) > 122) {
                    i++;
                } else {
                    break;
                }
            }
            while (j > i) {
                if (Integer.valueOf(arr[j]) < 65) {
                    j--;
                } else if ((Integer.valueOf(arr[j]) > 90)
                        && (Integer.valueOf(arr[j]) < 97)) {
                    j--;
                } else if (Integer.valueOf(arr[j]) > 122) {
                    j--;
                } else {
                    break;
                }
            }
            if (j > i) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            }
        }
        return new String(arr);
    }

    public static void main(String args[]) {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        System.out.println(rol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
