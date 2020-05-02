
public class MaxDifferenceYouCanGetFromChanginganInteger {

    public int maxDiff(int num) {
        //step 1
        String input = Integer.toString(num);
        char[] inputarr = input.toCharArray();
        char msd = input.charAt(0);

        if (msd != '9') {
            for (int i = 0; i < inputarr.length; i++) {
                if (msd == inputarr[i]) {
                    inputarr[i] = '9';
                }
            }
        } else {
            int index = 1;
            while (index < input.length()) {
                msd = input.charAt(index);
                if (msd == '9') {
                    index++;
                } else {
                    for (int i = 0; i < inputarr.length; i++) {
                        if (msd == inputarr[i]) {
                            inputarr[i] = '9';
                        }
                    }
                    break;
                }
            }
        }

        String a = new String(inputarr);

        // step 2
        inputarr = input.toCharArray();
        msd = input.charAt(0);
        if (msd != '1') {
            for (int i = 0; i < inputarr.length; i++) {
                if (msd == inputarr[i]) {
                    inputarr[i] = '1';
                }
            }
        } else {
            int index = 1;
            while (index < input.length()) {
                msd = input.charAt(index);
                if (msd == '0' || msd == input.charAt(0)) {
                    index++;
                } else {
                    for (int i = 1; i < inputarr.length; i++) {
                        if (msd == inputarr[i]) {
                            inputarr[i] = '0';
                        }
                    }
                    break;
                }
            }
        }

        String b = new String(inputarr);
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    public static void main(String args[]) {
        MaxDifferenceYouCanGetFromChanginganInteger mdycgfci = new MaxDifferenceYouCanGetFromChanginganInteger();
        System.out.println(mdycgfci.maxDiff(123456));
        System.out.println(mdycgfci.maxDiff(1101057));
        System.out.println(mdycgfci.maxDiff(555));
    }
}
