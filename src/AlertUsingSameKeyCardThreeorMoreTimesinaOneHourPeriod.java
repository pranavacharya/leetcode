
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> list = new ArrayList();
        HashMap<String, ArrayList<String>> map = new HashMap();
        for (int i = 0; i < keyName.length; i++) {
            ArrayList temp = map.getOrDefault(keyName[i], new ArrayList());
            temp.add(keyTime[i]);
            map.put(keyName[i], temp);
        }

        for (String key : map.keySet()) {
            ArrayList<String> time = map.get(key);
            if (inWindow(time)) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }

    private boolean inWindow(ArrayList<String> times) {
        ArrayList<Integer> minutes = new ArrayList();
        for (String time : times) {
            String[] splits = time.split(":");
            String hours = splits[0];
            String mins = splits[1];
            int min = Integer.parseInt(mins);
            min += (Integer.parseInt(hours) * 60);
            minutes.add(min);
        }
        Collections.sort(minutes);
        Deque<Integer> deque = new ArrayDeque();
        for (int min : minutes) {
            deque.addLast(min);
            while (!deque.isEmpty()) {
                if (deque.peekFirst() < min - 60) {
                    deque.pollFirst();
                } else {
                    break;
                }
            }
            if (deque.size() >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod ausctmtohp
                = new AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod();
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(ausctmtohp.alertNames(keyName, keyTime));
    }
}
