
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        HashSet<Float> set = new HashSet();
        List<String> result = new ArrayList();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!set.contains((float) i / (float) j)) {
                    set.add((float) i / (float) j);
                    result.add(i + "/" + j);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        SimplifiedFractions sf = new SimplifiedFractions();
        System.out.println(sf.simplifiedFractions(4));
    }
}
