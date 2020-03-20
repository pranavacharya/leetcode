
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            }
        }
        return (x == 0 && y == 0);
    }

    public static void main(String args[]) {
        RobotReturnToOrigin rrto = new RobotReturnToOrigin();
        System.out.println(rrto.judgeCircle("UD"));
    }
}
