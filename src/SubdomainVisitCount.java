
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visits = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            while (domain.length() > 0) {
                visits.put(domain, visits.getOrDefault(domain, 0) + count);
                int index = domain.indexOf(".");
                if (index == -1) {
                    break;
                }
                domain = domain.substring(index + 1);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String k : visits.keySet()) {
            list.add("" + visits.get(k) + " " + k);
        }
        return list;
    }

    public static void main(String args[]) {
        SubdomainVisitCount svc = new SubdomainVisitCount();
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(svc.subdomainVisits(cpdomains));
    }
}
