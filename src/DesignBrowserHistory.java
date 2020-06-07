
import java.util.Stack;

public class DesignBrowserHistory {

    private Stack<String> back;
    private Stack<String> forward;

    public DesignBrowserHistory(String homepage) {
        back = new Stack();
        forward = new Stack();
        back.push(homepage);
    }

    public void visit(String url) {
        back.push(url);
        forward.clear();
    }

    public String back(int steps) {
        while (back.size() > 1 && steps > 0) {
            String url = back.pop();
            forward.push(url);
            steps--;
        }
        return back.peek();
    }

    public String forward(int steps) {
        while (!forward.isEmpty() && steps > 0) {
            String url = forward.pop();
            back.push(url);
            steps--;
        }
        return back.peek();
    }

    public static void main(String args[]) {
        DesignBrowserHistory dbh = new DesignBrowserHistory("leetcode.com");
        dbh.visit("google.com");
        dbh.visit("yahoo.com");
        dbh.visit("youtube.com");
        System.out.println(dbh.back(1));
        System.out.println(dbh.back(1));
        System.out.println(dbh.forward(1));
        dbh.visit("linkedin.com");
        System.out.println(dbh.forward(2));
        System.out.println(dbh.back(2));
        System.out.println(dbh.back(7));

    }
}
