
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }
        int start = 0;
        int acc = 0;
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            if (acc + gain < 0) {
                start = i + 1;
                acc = 0;
            } else {
                acc = acc + gain;
            }
        }
        return start;
    }

    public static void main(String args[]) {
        GasStation gs = new GasStation();
        int[] gas = new int[]{3, 1, 1};
        int[] cost = new int[]{1, 2, 2};
//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
