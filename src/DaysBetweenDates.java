
import java.util.HashMap;

public class DaysBetweenDates {

    HashMap<Integer, Integer> months = new HashMap<>() {
        {
            put(1, 0);
            put(2, 31);
            put(3, 28);
            put(4, 31);
            put(5, 30);
            put(6, 31);
            put(7, 30);
            put(8, 31);
            put(9, 31);
            put(10, 30);
            put(11, 31);
            put(12, 30);
        }
    };

    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    public int daysBetweenDates(String date1, String date2) {

        int day1 = 0;
        int day2 = 0;

        char[] d1 = date1.toCharArray();
        char[] d2 = date2.toCharArray();

        int date1year = Character.getNumericValue(d1[0]);
        int date2year = Character.getNumericValue(d2[0]);
        for (int i = 1; i < 4; i++) {
            date1year = date1year * 10 + Character.getNumericValue(d1[i]);
            date2year = date2year * 10 + Character.getNumericValue(d2[i]);
        }
        for (int i = 0; i < date1year; i++) {
            day1 = day1 + ((isLeapYear(i) ? 366 : 365));
        }
        for (int i = 0; i < date2year; i++) {
            day2 = day2 + ((isLeapYear(i) ? 366 : 365));
        }

        int date1month = Character.getNumericValue(d1[5]);
        date1month = date1month * 10 + Character.getNumericValue(d1[6]);
        int date2month = Character.getNumericValue(d2[5]);
        date2month = date2month * 10 + Character.getNumericValue(d2[6]);
        for (int i = date1month; i > 0; i--) {
            int mon = months.get(i);
            day1 = day1 + (i == 3 && isLeapYear(date1year) ? mon + 1 : mon);
        }
        for (int i = date2month; i > 0; i--) {
            int mon = months.get(i);
            day2 = day2 + (i == 3 && isLeapYear(date2year) ? mon + 1 : mon);
        }

        int date1date = Character.getNumericValue(d1[8]);
        int date2date = Character.getNumericValue(d2[8]);
        date1date = date1date * 10 + Character.getNumericValue(d1[9]);
        date2date = date2date * 10 + Character.getNumericValue(d2[9]);

        day1 = day1 + date1date;
        day2 = day2 + date2date;

        return Math.abs(day1 - day2);
    }

    public static void main(String args[]) {
        DaysBetweenDates dbd = new DaysBetweenDates();
        String date1 = "2009-08-18";
        String date2 = "2080-08-08";
        System.out.println(dbd.daysBetweenDates(date1, date2));
    }
}
