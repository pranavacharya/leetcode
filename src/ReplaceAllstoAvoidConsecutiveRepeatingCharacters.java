
public class ReplaceAllstoAvoidConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i == s.length() - 1) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != j) {
                            sb.append(j);
                            break;
                        } else if (sb.length() == 0) {
                            sb.append(j);
                            break;
                        }
                    }
                } else if (sb.length() == 0) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (s.charAt(i + 1) != j) {
                            sb.append(j);
                            break;
                        }
                    }
                } else {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (sb.charAt(sb.length() - 1) != j && s.charAt(i + 1) != j && s.charAt(i + 1) != '?') {
                            sb.append(j);
                            break;
                        } else if (s.charAt(i + 1) == '?' && sb.charAt(sb.length() - 1) != j) {
                            sb.append(j);
                            break;
                        }
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        ReplaceAllstoAvoidConsecutiveRepeatingCharacters raacrc = new ReplaceAllstoAvoidConsecutiveRepeatingCharacters();
//        System.out.println(raacrc.modifyString("??yw?ipkj?"));
//        System.out.println(raacrc.modifyString("??"));
        System.out.println(raacrc.modifyString("?a?ub???w?b"));
    }
}
