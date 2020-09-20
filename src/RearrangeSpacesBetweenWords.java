
public class RearrangeSpacesBetweenWords {

    public String reorderSpaces(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }
        String[] words = text.split(" ");
        int wordCount = 0;
        for (String word : words) {
            if (word.length() > 0) {
                wordCount++;
            }
        }
        int equal;
        int lastSpace;
        if (wordCount == 1) {
            equal = 0;
            lastSpace = count;
        } else {
            equal = count / (wordCount - 1);
            lastSpace = count % (wordCount - 1);
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                if (flag) {
                    for (int j = 0; j < equal; j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[i]);
                flag = true;
            }
        }
        for (int i = 0; i < lastSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        RearrangeSpacesBetweenWords rsbw = new RearrangeSpacesBetweenWords();
        System.out.println(rsbw.reorderSpaces(" practice   makes   perfect"));
    }
}
