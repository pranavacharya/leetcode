
public class DesignParkingSystem {

    private int b;
    private int m;
    private int s;

    public DesignParkingSystem(int big, int medium, int small) {
        this.b = big;
        this.m = medium;
        this.s = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.b > 0) {
                this.b--;
                return true;
            }
        } else if (carType == 2) {
            if (this.m > 0) {
                this.m--;
                return true;
            }
        } else {
            if (this.s > 0) {
                this.s--;
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        DesignParkingSystem dps = new DesignParkingSystem(1, 1, 0);
        System.out.println(dps.addCar(1));
        System.out.println(dps.addCar(2));
        System.out.println(dps.addCar(3));
        System.out.println(dps.addCar(1));
    }
}
