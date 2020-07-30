
public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }

    public static void main(String args[]) {
        ShuffleString ss = new ShuffleString();
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(ss.restoreString("codeleet", indices));
    }
}
