
import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingaRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = -1;
        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else {
            index = 2;
        }
        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountItemsMatchingaRule cimr = new CountItemsMatchingaRule();
        List<List<String>> items = new ArrayList();
        List<String> item1 = new ArrayList();
        item1.add("phone");
        item1.add("blue");
        item1.add("pixel");
        List<String> item2 = new ArrayList();
        item2.add("computer");
        item2.add("silver");
        item2.add("lenovo");
        List<String> item3 = new ArrayList();
        item3.add("phone");
        item3.add("gold");
        item3.add("iphone");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        System.out.println(cimr.countMatches(items, "color", "silver"));
    }
}
