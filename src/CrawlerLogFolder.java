
public class CrawlerLogFolder {
    
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log: logs) {
            String[] cmds = log.split("/");
            String cmd = cmds[0];
            if(cmd.equals("..")){
                count--;
                if(count < 0){
                    count = 0;
                }
            } else if(cmd.equals(".")){
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String args[]){
        CrawlerLogFolder clf = new CrawlerLogFolder();
        String[] logs  = new String[]{"d1/","d2/","../","d21/","./"};
        System.out.println(clf.minOperations(logs));
    }
}
