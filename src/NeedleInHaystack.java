
public class NeedleInHaystack {

    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && !needle.isEmpty()) {
            return -1;
        } else if (needle.isBlank()) {
            return 0;
        } else {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        NeedleInHaystack nih = new NeedleInHaystack();
        System.out.println(nih.strStr("hello", "ll"));
    }
}
