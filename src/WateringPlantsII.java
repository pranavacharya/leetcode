
public class WateringPlantsII {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int mid = plants.length / 2;
        int count = 0;
        int cap1 = capacityA;
        for (int i = 0; i < mid; i++) {
            if (cap1 < plants[i]) {
                count++;
                cap1 = capacityA;
            }
            cap1 -= plants[i];
        }
        int cap2 = capacityB;
        for (int i = plants.length - 1; i >= mid; i--) {
            if (plants.length % 2 != 0 && i == mid) {
                if (Math.max(cap1, cap2) < plants[mid]) {
                    count++;
                }
                break;
            }
            if (cap2 < plants[i]) {
                count++;
                cap2 = capacityB;
            }
            cap2 -= plants[i];
        }
        return count;
    }

    public static void main(String[] args) {
        WateringPlantsII wp = new WateringPlantsII();
        int[] plants = new int[]{2, 3, 3};
        System.out.println(wp.minimumRefill(plants, 5, 5));
    }
}
