
public class NumberofLaserBeamsinaBank {

    public int numberOfBeams(String[] bank) {

        int last = 0;
        int count = 0;
        for (int i = 0; i < bank.length; i++) {
            int device = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    device++;
                }
            }
            count += (last * device);
            if (device != 0) {
                last = device;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofLaserBeamsinaBank blbb = new NumberofLaserBeamsinaBank();
        String[] bank = new String[]{"011001", "000000", "010100", "001000"};
        System.out.println(blbb.numberOfBeams(bank));
    }
}
