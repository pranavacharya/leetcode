
import java.util.HashMap;

public class HTMLEntityParser {

    private HashMap<String, String> map;

    public HTMLEntityParser() {
        map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
    }

    public String entityParser(String text) {
        String ans = text;
        for (String s : this.map.keySet()) {
            ans = ans.replaceAll(s, this.map.get(s));
        }
        return ans;
    }

    public static void main(String args[]) {
        HTMLEntityParser hep = new HTMLEntityParser();
        System.out.println(hep.entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
}
