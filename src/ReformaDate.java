
import java.util.HashMap;

public class ReformaDate {

    HashMap<String, String> month = new HashMap();

    public ReformaDate() {
        this.month.put("Jan", "01");
        this.month.put("Feb", "02");
        this.month.put("Mar", "03");
        this.month.put("Apr", "04");
        this.month.put("May", "05");
        this.month.put("Jun", "06");
        this.month.put("Jul", "07");
        this.month.put("Aug", "08");
        this.month.put("Sep", "09");
        this.month.put("Oct", "10");
        this.month.put("Nov", "11");
        this.month.put("Dec", "12");

    }

    public String reformatDate(String date) {
        String[] d = date.split(" ");
        String day = d[0].replaceAll("[^0-9]", "");
        if (day.length() == 1) {
            day = "0" + day;
        }
        return d[2] + "-" + this.month.get(d[1]) + "-" + day;
    }

    public static void main(String args[]) {
        ReformaDate rd = new ReformaDate();
        System.out.println(rd.reformatDate("6th Oct 2052"));
    }
}
