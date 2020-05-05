
public class Maximum69Number {

    public int maximum69Number(int num) {
        String n = Integer.toString(num);
        char[] narr = n.toCharArray();
        int index = 0;
        while (index < narr.length) {
            if (narr[index] < '9') {
                narr[index] = '9';
                break;
            }
            index++;
        }
        return Integer.parseInt(new String(narr));
    }

    public static void main(String args[]) {
        Maximum69Number m69n = new Maximum69Number();
        System.out.println(m69n.maximum69Number(9669));
    }
}
