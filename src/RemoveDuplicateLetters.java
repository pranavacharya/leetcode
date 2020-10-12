
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
            if (visited[index]) {
                continue;
            }
            while (!stack.isEmpty() && freq[stack.peek() - 'a'] != 0 && stack.peek() > c) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("bcabc"));
    }
}
