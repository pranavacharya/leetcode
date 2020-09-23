
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i;
        for (i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int j = i;
            int rc = gas[i] - cost[i];
            do {
                j++;
                j = (j % gas.length);
                if (gas[j] + rc < cost[j]) {
                    break;
                }
                rc = rc + gas[j] - cost[j];
                if (j == i - 1 || (i == 0 && j == gas.length - 1)) {
                    return i;
                }
            } while (j != i);
        }
        return -1;
    }

    public static void main(String args[]) {
        GasStation gs = new GasStation();
//        int[] gas = new int[]{3, 1, 1};
//        int[] cost = new int[]{1, 2, 2};
//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
