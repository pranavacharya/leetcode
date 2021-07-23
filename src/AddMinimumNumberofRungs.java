
public class AddMinimumNumberofRungs {

    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int last = 0;
        for (int i = 0; i < rungs.length; i++) {
            if (last + dist < rungs[i]) {
                int steps = (rungs[i] - last - 1) / dist;
                count += steps;
            }
            last = rungs[i];
        }
        return count;
    }

    public static void main(String[] args) {
        AddMinimumNumberofRungs amnr = new AddMinimumNumberofRungs();
        int[] rungs = new int[]{1, 3, 5, 10};
        System.out.println(amnr.addRungs(rungs, 2));
    }
}
