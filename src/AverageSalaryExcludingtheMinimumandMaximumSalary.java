
public class AverageSalaryExcludingtheMinimumandMaximumSalary {

    public double average(int[] salary) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        sum = sum - min - max;
        return (double) sum / (salary.length - 2);
    }

    public static void main(String args[]) {
        AverageSalaryExcludingtheMinimumandMaximumSalary asetmms = new AverageSalaryExcludingtheMinimumandMaximumSalary();
        int[] salary = new int[]{4000, 3000, 1000, 2000};
        System.out.println(asetmms.average(salary));
    }
}
