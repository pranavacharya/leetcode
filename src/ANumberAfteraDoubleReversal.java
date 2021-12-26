
public class ANumberAfteraDoubleReversal {

    public boolean isSameAfterReversals(int num) {

        if (num == 0) {
            return true;
        }

        if (num % 10 != 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ANumberAfteraDoubleReversal anadr = new ANumberAfteraDoubleReversal();
        System.out.println(anadr.isSameAfterReversals(0));
    }
}
