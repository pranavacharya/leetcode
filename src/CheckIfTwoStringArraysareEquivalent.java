
public class CheckIfTwoStringArraysareEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String args[]) {
        CheckIfTwoStringArraysareEquivalent stsae = new CheckIfTwoStringArraysareEquivalent();
        String[] arr1 = new String[]{"ab", "c"};
        String[] arr2 = new String[]{"a", "bc"};
        System.out.println(stsae.arrayStringsAreEqual(arr1, arr2));
    }
}
