
public class MinimumCosttoMoveChipstoTheSamePosition {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String args[]) {
        MinimumCosttoMoveChipstoTheSamePosition mctnctsp = new MinimumCosttoMoveChipstoTheSamePosition();
        int[] positions = new int[]{2, 2, 2, 3, 3};
        System.out.println(mctnctsp.minCostToMoveChips(positions));
    }
}
