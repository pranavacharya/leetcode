
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < arr.length && (!((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')))) {
                i++;
            }
            while (j >= 0 && (!((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z')))) {
                j--;
            }
            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;

        }
        return new String(arr);
    }

    public static void main(String args[]) {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        System.out.println(rol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
