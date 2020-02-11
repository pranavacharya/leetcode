
public class ThreeSum {
    
    public void subset(String soFar, String rem) {
        if (soFar.length() == 3) {
            char[] nums = soFar.toCharArray();
            int sum = 0;
            for (char i : nums) {
                sum += Character.getNumericValue(i);
            }
            if (sum == 6) {
                System.out.println(soFar + "," + sum);
            }
        } else if (!rem.isEmpty()) {
            subset(soFar + rem.substring(0, 1), rem.substring(1));
            subset(soFar, rem.substring(1));
        }
    }
    
    public static void main(String args[]) {
        ThreeSum ts = new ThreeSum();
        ts.subset("", "1234");
    }
}
