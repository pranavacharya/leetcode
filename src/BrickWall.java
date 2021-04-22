
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> layer = wall.get(i);
            int sum = 0;
            for (int j = 0; j < layer.size() - 1; j++) {
                sum += layer.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        BrickWall bw = new BrickWall();
        List<List<Integer>> wall = new ArrayList();
        List<Integer> one = new ArrayList();
        one.add(1);
        one.add(2);
        one.add(2);
        one.add(1);
        List<Integer> two = new ArrayList();
        two.add(3);
        two.add(1);
        two.add(2);
        List<Integer> three = new ArrayList();
        three.add(1);
        three.add(3);
        three.add(2);
        List<Integer> four = new ArrayList();
        four.add(2);
        four.add(4);
        List<Integer> five = new ArrayList();
        five.add(3);
        five.add(1);
        five.add(2);
        List<Integer> six = new ArrayList();
        six.add(1);
        six.add(3);
        six.add(1);
        six.add(1);
        wall.add(one);
        wall.add(two);
        wall.add(three);
        wall.add(four);
        wall.add(five);
        wall.add(six);
        System.out.println(bw.leastBricks(wall));
    }
}
