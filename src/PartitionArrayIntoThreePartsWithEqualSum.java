
public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }

        int count = 0;
        int index = 0;
        int local = 0;
        while (index < A.length) {
            local += A[index++];
            if (local == (sum / 3)) {
                count++;
                local = 0;
            }
        }
        if (sum == 0 && count >= 3) {
            return true;
        }
        return count == 3;
    }

    public static void main(String args[]) {
        PartitionArrayIntoThreePartsWithEqualSum paitpwes = new PartitionArrayIntoThreePartsWithEqualSum();
        int[] A = new int[]{10, -10, 10, -10, 10, -10, 10, -10};
        System.out.println(paitpwes.canThreePartsEqualSum(A));
    }
}
