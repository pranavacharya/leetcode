
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {

    HashMap<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        path.addFirst(departure);
    }

    public static void main(String args[]) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList();
        List<String> one = new ArrayList();
        List<String> two = new ArrayList();
        List<String> three = new ArrayList();
        List<String> four = new ArrayList();
        one.add("MUC");
        one.add("LHR");
        two.add("JFK");
        two.add("MUC");
        three.add("SFO");
        three.add("SJC");
        four.add("LHR");
        four.add("SFO");
        tickets.add(one);
        tickets.add(two);
        tickets.add(three);
        tickets.add(four);

//        List<String> one = new ArrayList();
//        List<String> two = new ArrayList();
//        List<String> three = new ArrayList();
//        one.add("JFK");
//        one.add("KUL");
//        two.add("JFK");
//        two.add("NRT");
//        three.add("NRT");
//        three.add("JFK");
//        tickets.add(one);
//        tickets.add(two);
//        tickets.add(three);
        System.out.println(ri.findItinerary(tickets));
    }
}
