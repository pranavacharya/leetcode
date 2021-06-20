
public class TheNumberofFullRoundsYouHavePlayed {

    public int numberOfRounds(String startTime, String finishTime) {
        int round = 0;
        int hr1 = Integer.parseInt(startTime.split(":")[0]);
        int min1 = Integer.parseInt(startTime.split(":")[1]);
        int hr2 = Integer.parseInt(finishTime.split(":")[0]);
        int min2 = Integer.parseInt(finishTime.split(":")[1]);

        int hr = 0;
        if (hr2 < hr1 || (hr2 == hr1 && min1 > min2)) {
            // overnight
            hr += 24 - hr1;
            hr += hr2;
        } else {
            hr = hr2 - hr1;
        }

        round += hr * 4;

        if (min2 >= 45) {
            round += 3;
        } else if (min2 >= 30) {
            round += 2;
        } else if (min2 >= 15) {
            round += 1;
        }

        if (min1 > 45) {
            round -= 4;
        } else if (min1 > 30) {
            round -= 3;
        } else if (min1 > 15) {
            round -= 2;
        } else if (min1 > 0) {
            round -= 1;
        }

        return round;
    }

    public static void main(String[] args) {
        TheNumberofFullRoundsYouHavePlayed tnfryhp = new TheNumberofFullRoundsYouHavePlayed();
        System.out.println(tnfryhp.numberOfRounds("12:01", "12:44"));
    }
}
