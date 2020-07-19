
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0;
        int empty = 0;
        int full = numBottles;
        while (full > 0) {
            drank += full;
            empty += full;
            full = empty / numExchange;
            empty = (empty % numExchange);
        }
        return drank;
    }

    public static void main(String args[]) {
        WaterBottles wb = new WaterBottles();
        System.out.println(wb.numWaterBottles(15, 4));
    }
}
