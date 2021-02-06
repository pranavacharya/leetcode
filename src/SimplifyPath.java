
import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        Stack<String> stack = new Stack();
        for (String split : splits) {
            if (split.isEmpty()) {
                continue;
            } else if (split.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (split.equals(".")) {
                continue;
            } else {
                stack.push(split);
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList(stack);
        for (int i = 0; i < list.size(); i++) {
            sb.append("/");
            sb.append(list.get(i));
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/../"));
        System.out.println(sp.simplifyPath("/home//foo/"));
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));
    }
}
