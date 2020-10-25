
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char ans = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] == maxDuration) {
                if (keysPressed.charAt(i) > ans) {
                    ans = keysPressed.charAt(i);
                }
            } else if (releaseTimes[i] - releaseTimes[i - 1] > maxDuration) {
                maxDuration = releaseTimes[i] - releaseTimes[i - 1];
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        SlowestKey sk = new SlowestKey();
        int[] releaseTimes = new int[]{9, 29, 49, 50};
        String keysPressed = "cbcd";
        System.out.println(sk.slowestKey(releaseTimes, keysPressed));
    }
}
