
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            if (c - '0' > max) {
                max = c - '0';
            }
        }
        return max;
    }

    public static void main(String args[]) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbers pimdn = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
        System.out.println(pimdn.minPartitions("82734"));
        System.out.println(pimdn.minPartitions("27346209830709182346"));
        System.out.println(pimdn.minPartitions("32"));
    }
}
