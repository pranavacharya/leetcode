
import java.util.Arrays;

public class GenerateRandomPointinaCircle {

    private double radius;
    private double x_center;
    private double y_center;

    public GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    // x -a ^ 2 + y - b ^ 2 = r ^ 2
    public double[] randPoint() {
        double length = Math.sqrt(Math.random()) * this.radius;
        double degree = Math.random() * 2 * Math.PI;
        double x = this.x_center + length * Math.cos(degree);
        double y = this.y_center + length * Math.sin(degree);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        GenerateRandomPointinaCircle grpc
                = new GenerateRandomPointinaCircle(1, 0, 0);
        System.out.println(Arrays.toString(grpc.randPoint()));
    }
}
