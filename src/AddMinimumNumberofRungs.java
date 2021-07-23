
public class AddMinimumNumberofRungs {

    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int last = 0;
        for (int i = 0; i < rungs.length;) {
            if (last + dist < rungs[i]) {
                last = last + dist;
                count++;
            } else {
                last = rungs[i];
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AddMinimumNumberofRungs amnr = new AddMinimumNumberofRungs();
        int[] rungs = new int[]{1, 3, 5, 10};
        System.out.println(amnr.addRungs(rungs, 2));
    }
}
