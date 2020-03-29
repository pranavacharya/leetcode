
import java.util.ArrayList;
import java.util.HashMap;

public class UndergroundSystem {

    private HashMap<String, ArrayList<Integer>> averageTime;
    private HashMap<Integer, String> passengers;

    public UndergroundSystem() {
        this.averageTime = new HashMap<>();
        this.passengers = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.passengers.put(id, stationName + "_" + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String[] p = this.passengers.get(id).split("_");
        int timediff = t - Integer.parseInt(p[1]);
        ArrayList get = this.averageTime.getOrDefault(p[0].concat(stationName), new ArrayList<>());
        get.add(timediff);
        this.averageTime.put(p[0].concat(stationName), new ArrayList(get));
    }

    public double getAverageTime(String startStation, String endStation) {
        ArrayList<Integer> result = this.averageTime.get(startStation.concat(endStation));
        Double totalTime = 0.0;
        for (int i : result) {
            totalTime += i;
        }
        return totalTime / result.size();
    }

    public static void main(String args[]) {
        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(1, "manpada", 12);
        obj.checkOut(1, "thane", 41);
        System.out.println(obj.getAverageTime("manpada", "thane"));
    }
}
