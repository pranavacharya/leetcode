
import java.util.ArrayList;
import java.util.List;

public class DesignanOrderedStream {

    private int pointer;
    private String[] arr;

    public DesignanOrderedStream(int n) {
        this.pointer = 1;
        this.arr = new String[n];
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = "";
        }
    }

    public List<String> insert(int id, String value) {
        this.arr[id - 1] = value;
        List<String> result = new ArrayList();
        if (this.pointer == id) {
            for (int i = id - 1; i < this.arr.length; i++) {
                if (arr[i].isEmpty()) {
                    break;
                }
                result.add(this.arr[i]);
                this.pointer = i + 2;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        DesignanOrderedStream dos = new DesignanOrderedStream(3);
        System.out.println(dos.insert(1, "aaa"));
        System.out.println(dos.insert(2, "bbb"));
        System.out.println(dos.insert(3, "aaa"));
    }
}
