
public class CalculateAmountPaidinTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        boolean done = false;
        for (int i = 0; i < brackets.length; i++) {
            if (income <= 0 || done) {
                break;
            }
            if (income <= brackets[i][0]) {
                done = true;
            }
            double amount = i == 0 ? Math.min(income, brackets[i][0]) : Math.min(income, brackets[i][0]) - brackets[i - 1][0];
            tax += ((amount * (double) brackets[i][1]) / 100);
        }

        return tax;
    }

    public static void main(String[] args) {
        CalculateAmountPaidinTaxes ct = new CalculateAmountPaidinTaxes();
//        int[][] brackets = new int[][]{{3, 50}, {7, 10}, {12, 25}};
        int[][] brackets = new int[][]{{1, 0}, {4, 25}, {5, 50}};
//        System.out.println(ct.calculateTax(brackets, 10));
        System.out.println(ct.calculateTax(brackets, 2));
    }
}
