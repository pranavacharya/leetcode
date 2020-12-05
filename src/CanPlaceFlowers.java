
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean start = false;
        int ideal = 0;
        int local = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                local++;
            } else {
                if (!start) {
                    start = true;
                    ideal += local / 2;
                } else {
                    ideal += (local - 1) / 2;
                }
                local = 0;
            }
            if (ideal >= n) {
                return true;
            }
        }

        if (!start) {
            ideal += (local + 1) / 2;
        } else {
            ideal += local / 2;
        }
        if (ideal >= n) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] flowerbed = new int[]{0};
        System.out.println(cpf.canPlaceFlowers(flowerbed, 1));
    }
}
