
public class CountVowelSubstringsofaString {

    public int countVowelSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                int a = 0;
                int e = 0;
                int ic = 0;
                int o = 0;
                int u = 0;
                int other = 0;
                for (int k = i; k <= j; k++) {
                    if (word.charAt(k) == 'a') {
                        a++;
                    } else if (word.charAt(k) == 'e') {
                        e++;
                    } else if (word.charAt(k) == 'i') {
                        ic++;
                    } else if (word.charAt(k) == 'o') {
                        o++;
                    } else if (word.charAt(k) == 'u') {
                        u++;
                    } else {
                        other++;
                    }
                }
                if (!(other > 0 || a == 0 || e == 0 || ic == 0 || o == 0 || u == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountVowelSubstringsofaString cvss = new CountVowelSubstringsofaString();
        System.out.println(cvss.countVowelSubstrings("aeiouu"));
    }
}
