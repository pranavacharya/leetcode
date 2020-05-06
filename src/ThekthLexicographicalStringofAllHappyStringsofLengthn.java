
import java.util.ArrayList;

public class ThekthLexicographicalStringofAllHappyStringsofLengthn {

    private String result;
    private int count;

    public ThekthLexicographicalStringofAllHappyStringsofLengthn() {
        this.result = "";
        this.count = 0;
    }

    public String getHappyString(int n, int k) {
        this.count = k;
        backtracking(new ArrayList(), n);
        return this.result;
    }

    public boolean backtracking(ArrayList<Character> path, int n) {
        if (path.size() == n) {
            this.count--;
            if (this.count == 0) {
                StringBuilder sb = new StringBuilder();
                for (char c : path) {
                    sb.append(c);
                }
                this.result = sb.toString();
                return true;
            }
            return false;
        } else {
            for (char i = 'a'; i <= 'c'; i++) {
                if (path.size() > 0 && path.get(path.size() - 1) == i) {
                    continue;
                }
                path.add(i);
                if (backtracking(path, n)) {
                    return true;
                } else {
                    path.remove(path.size() - 1);
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        ThekthLexicographicalStringofAllHappyStringsofLengthn lklshs = new ThekthLexicographicalStringofAllHappyStringsofLengthn();
        System.out.println(lklshs.getHappyString(10, 100));
    }
}
