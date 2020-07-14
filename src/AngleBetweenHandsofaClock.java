
public class AngleBetweenHandsofaClock {

    public double angleClock(int hour, int minutes) {
        double hourFraction = (hour % 12) + ((double) minutes / 60);
        double minFraction = (double) minutes / 5;
        double angle = Math.min(Math.abs(hourFraction - minFraction),
                Math.min((12 - hourFraction + minFraction), (12 - minFraction + hourFraction)));
        return angle * 30;
    }

    public static void main(String args[]) {
        AngleBetweenHandsofaClock abhc = new AngleBetweenHandsofaClock();
        System.out.println(abhc.angleClock(8, 7));
    }
}
