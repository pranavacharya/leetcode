
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> minqueue = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer num : rooms.get(0)) {
            if (!queue.contains(num)) {
                queue.add(num);
            }
        }
        minqueue.add(0);
        maxqueue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            maxqueue.add(temp);
            minqueue.add(temp);
            for (Integer num : rooms.get(temp)) {
                if (!minqueue.contains(num) && !queue.contains(num) && num != 0) {
                    queue.add(num);
                }
            }
        }
        return (rooms.size() == minqueue.size() && minqueue.remove() == 0 && maxqueue.remove() == rooms.size() - 1);
    }

    public static void main(String args[]) {
        KeysAndRooms kar = new KeysAndRooms();
        List<List<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);
        System.out.println(kar.canVisitAllRooms(input));
    }
}
