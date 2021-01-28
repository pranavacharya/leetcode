
import java.util.HashMap;
import java.util.HashSet;

public class MinimumNumberofPeopletoTeach {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer, HashSet<Integer>> langMap = new HashMap();
        for (int i = 0; i < languages.length; i++) {
            HashSet<Integer> set = new HashSet();
            for (int j = 0; j < languages[i].length; j++) {
                set.add(languages[i][j]);
            }
            langMap.put(i + 1, set);
        }

        boolean[] common = new boolean[friendships.length];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < friendships.length; j++) {
                if (langMap.get(friendships[j][0]).contains(i) && langMap.get(friendships[j][1]).contains(i)) {
                    common[j] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = new HashSet();
            for (int j = 0; j < friendships.length; j++) {
                if (common[j]) {
                    continue;
                }
                if (!langMap.get(friendships[j][0]).contains(i)) {
                    set.add(friendships[j][0]);
                }
                if (!langMap.get(friendships[j][1]).contains(i)) {
                    set.add(friendships[j][1]);
                }
            }

            min = Math.min(min, set.size());
        }

        return min;
    }

    public static void main(String args[]) {
        MinimumNumberofPeopletoTeach mnpt = new MinimumNumberofPeopletoTeach();
        int[][] languages = new int[][]{{2}, {1, 3}, {1, 2}, {3}};
        int[][] friendships = new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}};
        System.out.println(mnpt.minimumTeachings(2, languages, friendships));
    }

}
