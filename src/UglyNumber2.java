
import java.util.ArrayList;

public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList();
        int first = 0;
        int second = 0;
        int third = 0;
        list.add(1);
        n--;
        while (n > 0) {
            int two = 2 * list.get(first);
            int three = 3 * list.get(second);
            int five = 5 * list.get(third);

            int min = Math.min(two, Math.min(three, five));

            if (min == two) {
                first++;
            }

            if (min == three) {
                second++;
            }

            if (min == five) {
                third++;
            }

            list.add(min);
            n--;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String args[]) {
        UglyNumber2 ug = new UglyNumber2();
        System.out.println(ug.nthUglyNumber(20));
    }
}
