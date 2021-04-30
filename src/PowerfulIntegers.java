
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet();
        for (int i = 1; i <= bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        List<Integer> list = new ArrayList(set);
        return list;
    }

    public static void main(String[] args) {
        PowerfulIntegers pi = new PowerfulIntegers();
        System.out.println(pi.powerfulIntegers(2, 3, 10));
    }
}
