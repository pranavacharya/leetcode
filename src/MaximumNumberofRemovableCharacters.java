
public class MaximumNumberofRemovableCharacters {

    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 1;
        int high = removable.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(s, p, removable, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    private boolean isValid(String s, String p, int[] removable, int index) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < index; i++) {
            arr[removable[i]] = '.';
        }
        int i = 0;
        int j = 0;
        while (j < p.length()) {
            while (i < arr.length && arr[i] == '.') {
                i++;
            }
            if (i == arr.length && j != p.length()) {
                return false;
            }
            if (arr[i] == p.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        MaximumNumberofRemovableCharacters mnrc = new MaximumNumberofRemovableCharacters();
        int[] removable = new int[]{3, 1, 0};
        System.out.println(mnrc.maximumRemovals("abcacb", "ab", removable));
    }
}
