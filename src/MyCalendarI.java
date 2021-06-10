
import java.util.ArrayList;

public class MyCalendarI {

    ArrayList<int[]> list;

    public MyCalendarI() {
        this.list = new ArrayList();
    }

    public boolean book(int start, int end) {
        int index = 0;
        for (int i = 0; i < this.list.size(); i++) {
            if ((end > this.list.get(i)[0] && end <= this.list.get(i)[1])
                    || (start >= this.list.get(i)[0] && start < this.list.get(i)[1])
                    || (start <= this.list.get(i)[0] && end >= this.list.get(i)[1])
                    || (start >= this.list.get(i)[0] && end <= this.list.get(i)[1])) {
                return false;
            } else if (end <= this.list.get(i)[0]) {
                index = i;
                break;
            } else {
                index = i + 1;
            }
        }
        this.list.add(index, new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarI mc = new MyCalendarI();
        System.out.println(mc.book(10, 20));
        System.out.println(mc.book(15, 25));
        System.out.println(mc.book(20, 30));
    }
}
