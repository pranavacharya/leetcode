public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
public static void main(String args[]) {
        DefangingAnIPAddress daia = new DefangingAnIPAddress();
        System.out.println(daia.defangIPaddr("1.1.1.1"));    }    
}
