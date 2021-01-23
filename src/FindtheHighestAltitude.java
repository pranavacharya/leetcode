
public class FindtheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int alltitude = 0;
        int maxAlltitude = 0;
        for (int i = 0; i < gain.length; i++) {

            alltitude += gain[i];
            maxAlltitude = Math.max(maxAlltitude, alltitude);
        }
        return maxAlltitude;
    }

    public static void main(String args[]) {
        FindtheHighestAltitude ftha = new FindtheHighestAltitude();
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(ftha.largestAltitude(gain));
    }
}
