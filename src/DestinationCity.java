
import java.util.ArrayList;
import java.util.List;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        if (paths.isEmpty()) {
            return "";
        }
        List<String> first = paths.get(0);
        String des = first.get(1);
        for (int i = 1; i < paths.size(); i++) {
            String src = paths.get(i).get(0);
            if (src.equals(des)) {
                des = paths.get(i).get(1);
                i = 0;
            }
        }
        return des;
    }

    public static void main(String args[]) {
        DestinationCity dc = new DestinationCity();
        List<List<String>> paths = new ArrayList();
        List<String> route1 = new ArrayList();
        route1.add("B");
        route1.add("C");
        List<String> route2 = new ArrayList();
        route2.add("D");
        route2.add("B");
        List<String> route3 = new ArrayList();
        route3.add("C");
        route3.add("A");
        paths.add(route1);
        paths.add(route2);
        paths.add(route3);
        System.out.println(dc.destCity(paths));
    }
}
