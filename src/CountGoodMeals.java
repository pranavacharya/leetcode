
import java.util.HashMap;
import java.util.HashSet;

public class CountGoodMeals {

    private int mod = 1000000007;

    public int countPairs(int[] deliciousness) {
        HashSet<Double> powers = new HashSet();
        for (int i = 0; i <= 21; i++) {
            powers.add(Math.pow(2, i));
        }
        HashMap<Integer, Integer> map = new HashMap();
        int pairs = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (double power : powers) {
                if (map.containsKey((int) power - deliciousness[i])) {
                    pairs = (pairs % mod + map.get((int) power - deliciousness[i]) % mod) % mod;
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return pairs;
    }

    public static void main(String args[]) {
        CountGoodMeals cgm = new CountGoodMeals();
//        int[] deliciousness = new int[]{1, 3, 5, 7, 9};
        int[] deliciousness = new int[]{1048576, 1048576};
        System.out.println(cgm.countPairs(deliciousness));
    }
}
