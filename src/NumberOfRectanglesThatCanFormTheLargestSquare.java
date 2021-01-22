
public class NumberOfRectanglesThatCanFormTheLargestSquare {

    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int length = rectangles[i][0];
            int breadh = rectangles[i][1];
            if (Math.min(length, breadh) == max) {
                count++;
            } else if (Math.min(length, breadh) > max) {
                max = Math.min(length, breadh);
                count = 1;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberOfRectanglesThatCanFormTheLargestSquare nrls = new NumberOfRectanglesThatCanFormTheLargestSquare();
        int[][] rectangles = new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(nrls.countGoodRectangles(rectangles));
    }
}
