
import java.util.Arrays;

public class ConstructtheRectangle {

    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        if (sqrt == Math.floor(sqrt)) {
            return new int[]{(int) sqrt, (int) sqrt};
        }
        int sqr = (int) sqrt;

        while (sqr > 0) {
            if (area % sqr == 0) {

                return new int[]{area / sqr, sqr};
            }
            sqr--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        ConstructtheRectangle ctr = new ConstructtheRectangle();
        System.out.println(Arrays.toString(ctr.constructRectangle(4)));
        System.out.println(Arrays.toString(ctr.constructRectangle(37)));
        System.out.println(Arrays.toString(ctr.constructRectangle(122122)));
    }
}
