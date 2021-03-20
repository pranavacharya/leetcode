
import java.util.ArrayList;
import java.util.HashMap;

public class DesignUndergroundSystem {

    class Passenger {

        int id;
        String checkinStationName;
        String checkoutStationName;
        int startTime;
        int endTime;

        public String getCheckoutStationName() {
            return checkoutStationName;
        }

        public void setCheckoutStationName(String checkoutStationName) {
            this.checkoutStationName = checkoutStationName;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public Passenger(int id, String checkinStationName, int startTime) {
            this.id = id;
            this.checkinStationName = checkinStationName;
            this.startTime = startTime;
        }

    }

    private HashMap<Integer, Passenger> passenger;
    private HashMap<String, ArrayList<Integer>> route;

    public DesignUndergroundSystem() {
        this.passenger = new HashMap();
        this.route = new HashMap();

    }

    public void checkIn(int id, String stationName, int t) {
        Passenger ps = new Passenger(id, stationName, t);
        this.passenger.put(id, ps);
    }

    public void checkOut(int id, String stationName, int t) {
        Passenger ps = this.passenger.get(id);
        ps.setCheckoutStationName(stationName);
        ps.setEndTime(t);
        this.route.putIfAbsent(ps.checkinStationName + "_" + stationName, new ArrayList());
        this.route.get(ps.checkinStationName + "_" + stationName).add(ps.endTime - ps.startTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        ArrayList<Integer> list = this.route.get(startStation + "_" + endStation);
        if (list.isEmpty()) {
            return 0;
        }
        double avg = 0.0;
        for (int i = 0; i < list.size(); i++) {
            avg += list.get(i);
        }
        return avg / (double) list.size();
    }

    public static void main(String[] args) {
        DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }
}
