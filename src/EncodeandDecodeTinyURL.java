
import java.util.HashMap;

public class EncodeandDecodeTinyURL {

    private HashMap<Integer, String> map;

    public EncodeandDecodeTinyURL() {
        this.map = new HashMap();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int tiny = longUrl.hashCode();
        this.map.put(tiny, longUrl);
        return "http://tinyurl.com/" + tiny;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hash = Integer.parseInt(shortUrl.substring(19));
        return this.map.get(hash);
    }

    public static void main(String[] args) {
        EncodeandDecodeTinyURL edtu = new EncodeandDecodeTinyURL();
        System.out.println(edtu.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(edtu.decode(edtu.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
