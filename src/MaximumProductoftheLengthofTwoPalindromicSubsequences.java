
public class MaximumProductoftheLengthofTwoPalindromicSubsequences {

    private int max = 0;

    public int maxProduct(String s) {
        palindromeSubsequence(new int[s.length()], s, 0, "", 0);
        return this.max;
    }

    private void palindromeSubsequence(int[] flag, String word, int length, String path, int index) {
        for (int i = index; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                path = path + word.charAt(i);
                length++;
                if (isPalindrome(path)) {
                    secondLongest = 0;
                    secondPalindromeSubsequence(flag, word, 0, "", 0);
                    int product = length * secondLongest;
                    this.max = Math.max(this.max, product);
                }
                palindromeSubsequence(flag, word, length, path, i + 1);
                flag[i] = 0;
                path = path.substring(0, path.length() - 1);
                length--;
            }
        }
    }

    private int secondLongest = 0;

    private void secondPalindromeSubsequence(int[] flag, String word, int length, String path, int index) {
        for (int i = index; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                path = path + word.charAt(i);
                length++;
                if (isPalindrome(path)) {
//                    System.out.println(path);
                    this.secondLongest = Math.max(this.secondLongest, length);
                }
                secondPalindromeSubsequence(flag, word, length, path, i + 1);
                flag[i] = 0;
                path = path.substring(0, path.length() - 1);
                length--;
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumProductoftheLengthofTwoPalindromicSubsequences mpltps = new MaximumProductoftheLengthofTwoPalindromicSubsequences();
        System.out.println(mpltps.maxProduct("leetcodecom"));
    }
}
