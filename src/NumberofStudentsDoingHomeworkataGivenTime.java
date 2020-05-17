
public class NumberofStudentsDoingHomeworkataGivenTime {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberofStudentsDoingHomeworkataGivenTime nsdhgt = new NumberofStudentsDoingHomeworkataGivenTime();
        int[] startTime = new int[]{1, 2, 3};
        int[] endTime = new int[]{3, 2, 7};
        System.out.println(nsdhgt.busyStudent(startTime, endTime, 4));
    }
}
