
import java.util.HashSet;

public class PathCrossing {

    public boolean isPathCrossing(String path) {
        HashSet<String> visited = new HashSet();
        int x = 0;
        int y = 0;
        visited.add("0,0");
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                x++;
            } else if (c == 'S') {
                x--;
            } else if (c == 'W') {
                y--;
            } else {
                y++;
            }
            String co = "" + x + "," + y;
            if (!visited.add(co)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        PathCrossing pc = new PathCrossing();
        System.out.println(pc.isPathCrossing("NESWW"));
    }
}
