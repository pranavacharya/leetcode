
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DifferenceInString {

    public char findTheDifference(String s, String t) {
        if (t.isEmpty()) {
            return '?';
        }
        HashMap<Character, Integer> frequencys = new HashMap<>();
        HashMap<Character, Integer> frequencyt = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (!frequencys.containsKey(sArray[i])) {
                frequencys.put(sArray[i], 1);
            } else {
                frequencys.replace(sArray[i], frequencys.get(sArray[i]) + 1);
            }

        }
        for (int i = 0; i < tArray.length; i++) {
            if (!frequencyt.containsKey(tArray[i])) {
                frequencyt.put(tArray[i], 1);
            } else {
                frequencyt.replace(tArray[i], frequencyt.get(tArray[i]) + 1);
            }
        }
        Iterator ftIterator = frequencyt.entrySet().iterator(); 
        while (ftIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)ftIterator.next();
            if (frequencys.get(mapElement.getKey()) != mapElement.getValue())
                return (char)mapElement.getKey();
        } 
        return tArray[0];
    }

    public static void main(String args[]) {
        DifferenceInString dis = new DifferenceInString();
        System.out.println(dis.findTheDifference("aafc", "caafe"));
    }
}
