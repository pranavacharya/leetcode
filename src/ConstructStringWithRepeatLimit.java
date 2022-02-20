
import java.util.PriorityQueue;




public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a ,b) -> (b[0] - a[0]));
        
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                queue.add(new int[]{i ,freq[i]});                
            }
        }
        int last = -1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            if(count < repeatLimit) {
                int[] curr = queue.poll();
                if(last == curr[0]) {
                    count++;
                } else if(last == -1) {
                    last = curr[0];
                    count++;
                }
                else {
                    last = curr[0];
                    count = 1;
                }
                char c = 'a';
                sb.append((c += curr[0]));
                curr[1]--;
                if(curr[1] != 0) {
                    queue.add(curr);
                } else {
                    count = 0;
                }
            } else {
                int[] save_top = queue.poll();
                if (queue.isEmpty()) {
                    return sb.toString();
                }
                int[] curr = queue.poll();
                if(last == curr[0]) {
                    count++;
                } else if(last == -1) {
                    last = curr[0];
                    count++;
                }
                else {
                    last = curr[0];
                    count = 0;
                }
                char c = 'a';
                sb.append((c += curr[0]));
                curr[1]--;
                if(curr[1] != 0) {
                    queue.add(curr);
                }
                queue.add(save_top);
            }
        }
        int pointer = 0;
        boolean flag = false;
        while(pointer < sb.length()) {
            int count_index = 0;
            int i = pointer;
            while(i < sb.length() && sb.charAt(pointer) == sb.charAt(i)) {
                i++;
                count_index++;
                if(count_index > repeatLimit) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
            pointer = i;
        }
        return sb.toString().substring(0, Math.min(sb.length(), pointer + repeatLimit));
    }
    
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit cswrl = new ConstructStringWithRepeatLimit();
        System.out.println(cswrl.repeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy", 2));
    }
}


//"robnsdvpuxbapuqgopqvxdrchivlifeepy"
//2