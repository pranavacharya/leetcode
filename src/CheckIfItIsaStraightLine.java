
public class CheckIfItIsaStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 0 || coordinates.length == 1) {
            return true;
        }
        int height = (coordinates[1][1] - coordinates[0][1]);
        int width = (coordinates[1][0] - coordinates[0][0]);
        float slope;
        if (width != 0) {
            slope = (float) height / (float) width;
        } else {
            slope = (float) Integer.MAX_VALUE;
        }
        for (int i = 2; i < coordinates.length; i++) {
            int localheight = (coordinates[i][1] - coordinates[0][1]);
            int localwidth = (coordinates[i][0] - coordinates[0][0]);
            float localslope;
            if (localwidth != 0) {
                localslope = (float) localheight / (float) localwidth;
            } else {
                localslope = (float) Integer.MAX_VALUE;
            }
            if (slope != localslope) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CheckIfItIsaStraightLine cisl = new CheckIfItIsaStraightLine();
        int[][] coordinates = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(cisl.checkStraightLine(coordinates));
    }
}
