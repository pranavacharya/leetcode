
import java.util.ArrayList;

public class ProductOfLastKNumbers {

    private ArrayList<Integer> list;

    public ProductOfLastKNumbers() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        this.list.add(num);
    }

    public int getProduct(int k) {
        int size = this.list.size();
        int output = 1;
        for (int i = size - 1; i >= 0 && k > 0; k--, i--) {
            output = output * this.list.get(i);
        }
        return output;
    }

    public static void main(String args[]) {
        ProductOfLastKNumbers productOfNumbers = new ProductOfLastKNumbers();
        productOfNumbers.add(7);      
        productOfNumbers.add(4);    
        productOfNumbers.add(5);   
        System.out.println(productOfNumbers.getProduct(3));

//        productOfNumbers.add(3);        // [3]
//        productOfNumbers.add(0);        // [3,0]
//        productOfNumbers.add(2);        // [3,0,2]
//        productOfNumbers.add(5);        // [3,0,2,5]
//        productOfNumbers.add(4);        // [3,0,2,5,4]
//        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
//        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
//        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
//        productOfNumbers.add(8);        // [3,0,2,5,4,8]
//        System.out.println(productOfNumbers.getProduct(2));
    }
}
