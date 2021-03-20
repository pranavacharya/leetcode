
public class LargestDigitinaString {

    public int secondHighest(String s) {
        int largest = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (s.charAt(i) - '0' > largest) {
                    largest = s.charAt(i) - '0';
                }
            }
        }
        int secondLargest = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (s.charAt(i) - '0' > secondLargest && (s.charAt(i) - '0') != largest) {
                    secondLargest = s.charAt(i) - '0';
                }
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        LargestDigitinaString lds = new LargestDigitinaString();
        System.out.println(lds.secondHighest("dfa12321afd"));
    }
}
