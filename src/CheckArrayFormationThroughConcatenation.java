
public class CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int index = 0;
        while (index < arr.length) {
            int temp = index;
            for (int j = 0; j < pieces.length; j++) {
                int[] piece = pieces[j];
                for (int k = 0; k < piece.length; k++) {
                    if (arr[index] == piece[k]) {
                        index++;
                    } else {
                        index = temp;
                        break;
                    }
                }
                if (index != temp) {
                    break;
                }
            }
            if (index == temp) {
                return false;
            }
        }
        return index == arr.length;
    }

    public static void main(String args[]) {
        CheckArrayFormationThroughConcatenation caftc = new CheckArrayFormationThroughConcatenation();
        int[] arr = new int[]{15, 88};
        int[][] pieces = new int[][]{{88}, {15}};
        System.out.println(caftc.canFormArray(arr, pieces));
    }
}
