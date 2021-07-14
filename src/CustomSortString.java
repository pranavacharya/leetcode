
public class CustomSortString {

    public String customSortString(String order, String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        char[] ans = new char[str.length()];
        int index = 0;
        for (int i = 0; i < order.length(); i++) {
            int count = freq[order.charAt(i) - 'a'];
            freq[order.charAt(i) - 'a'] = 0;
            for (int j = 0; j < count; j++) {
                ans[index++] = order.charAt(i);
            }
        }
        for (int i = 0; i < freq.length; i++) {
            int count = freq[i];
            for (int j = 0; j < count; j++) {
                char c = 'a';
                c += i;
                ans[index++] = c;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        CustomSortString css = new CustomSortString();
        System.out.println(css.customSortString("cba", "abcd"));
    }
}
