
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            List<Integer> list = rooms.get(queue.remove());
            for (Integer num : list) {
                if (!visited.contains(num)) {
                    visited.add(num);
                    queue.add(num);
                }
            }
        }
        return (rooms.size() == visited.size());
    }

    public static void main(String args[]) {
        KeysAndRooms kar = new KeysAndRooms();
        List<List<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(2);
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
