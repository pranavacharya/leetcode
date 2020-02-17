
import java.util.ArrayList;

public class ProductOfLastKNumbers {

    private ArrayList<Integer> list;

    public ProductOfLastKNumbers() {
        this.list = new ArrayList<>();
        this.add(0);
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1);
        } else {
            list.add(list.get(list.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k > list.size() - 1) {
            return 0;
        } else {
            int len = list.size();
            return (list.get(len - 1) / list.get(len - k - 1));
        }
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
