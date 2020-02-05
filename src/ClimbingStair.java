
public class ClimbingStair {

    public static int stair(int soFar, int target, int[] memory) {
        if (soFar == target) {
            return 1;
        }
        if (soFar > target) {
            return 0;
        }
        if (memory[soFar] > 0) {
            return memory[soFar];
        }
        
        memory[soFar] = stair(soFar + 1, target, memory) + stair(soFar + 2, target, memory);
        
        return memory[soFar];
    }

    public int climbStairs(int n) {
        int[] memory = new int[n];
        int count = stair(0, n, memory);
        return count;
    }

    public static void main(String args[]) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(44));
    }
}
