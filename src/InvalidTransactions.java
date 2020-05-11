
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InvalidTransactions {

    public class T {

        int index;
        int min;
        String place;

        public T(int min, String place, int index) {
            this.index = index;
            this.min = min;
            this.place = place;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList();
        HashMap<String, ArrayList<T>> map = new HashMap();
        for (int i = 0; i < transactions.length; i++) {
            String[] arr = transactions[i].split(",");
            String name = arr[0];
            int min = Integer.parseInt(arr[1]);
            int amount = Integer.parseInt(arr[2]);
            String place = arr[3];
            if (amount > 1000) {
                result.add(transactions[i]);
            }
            ArrayList<T> temp = map.getOrDefault(name, new ArrayList());
            temp.add(new T(min, place, i));
            map.put(name, new ArrayList(temp));
        }
        for (String key : map.keySet()) {
            ArrayList<T> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (Math.abs(list.get(i).min - list.get(j).min) <= 60 && !list.get(i).place.equals(list.get(j).place)) {
                        if (!result.contains(transactions[list.get(i).index])) {
                            result.add(transactions[list.get(i).index]);
                        }
                        if (!result.contains(transactions[list.get(j).index])) {
                            result.add(transactions[list.get(j).index]);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        InvalidTransactions iv = new InvalidTransactions();
        String[] transactions = new String[]{"alice,20,800,mtv", "alice,50,100,beijing"};
        System.out.println(iv.invalidTransactions(transactions));
    }
}
