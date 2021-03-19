
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet();
        return dfs(0, visited, rooms);
    }

    private boolean dfs(int room, HashSet<Integer> visited, List<List<Integer>> rooms) {
        visited.add(room);
        if (visited.size() == rooms.size()) {
            return true;
        }
        List<Integer> keys = rooms.get(room);
        for (int i = 0; i < keys.size(); i++) {
            if (!visited.contains(keys.get(i)) && dfs(keys.get(i), visited, rooms)) {
                return true;
            }
        }
        return false;
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
