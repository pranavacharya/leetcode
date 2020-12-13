
public class ValidBoomerang {

    public boolean isBoomerang(int[][] points) {
        int[] point1 = points[0];
        int[] point2 = points[1];
        int[] point3 = points[2];

        return ((point1[1] - point2[1]) * (point1[0] - point3[0])) != ((point1[1] - point3[1]) * (point1[0] - point2[0]));
    }

    public static void main(String args[]) {
        ValidBoomerang vb = new ValidBoomerang();
        int[][] points = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        System.out.println(vb.isBoomerang(points));
    }
}
