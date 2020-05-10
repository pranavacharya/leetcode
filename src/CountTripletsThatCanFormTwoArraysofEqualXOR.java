
public class CountTripletsThatCanFormTwoArraysofEqualXOR {

    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            for (int j = i; j < arr.length; j++) {
                a = a ^ arr[j];
                int b = 0;
                for (int k = j + 1; k < arr.length; k++) {
                    b = b ^ arr[k];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        CountTripletsThatCanFormTwoArraysofEqualXOR cttcftoexor = new CountTripletsThatCanFormTwoArraysofEqualXOR();
        int[] arr = new int[]{2, 3, 1, 6, 7};
        System.out.println(cttcftoexor.countTriplets(arr));
    }
}
