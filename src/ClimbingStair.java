
public class ClimbingStair {

    public int climbStairs(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String args[]) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(44));
    }
}
