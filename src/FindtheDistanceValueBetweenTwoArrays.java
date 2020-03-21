
public class FindtheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean status = true;
            for (int j : arr2) {
                if (Math.abs((i - j)) <= d) {
                    status = false;
                }
            }
            if (status) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        FindtheDistanceValueBetweenTwoArrays fdvbta = new FindtheDistanceValueBetweenTwoArrays();
        int[] arr1 = new int[]{1, 4, 2, 3};
        int[] arr2 = new int[]{-4, -3, 6, 10, 20, 30};
        System.out.println(fdvbta.findTheDistanceValue(arr1, arr2, 3));
    }
}
