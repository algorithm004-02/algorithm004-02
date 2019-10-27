package WEEK2.LeetCode;

public class RecursionTemplate {

    private int MAX_LAVEL;

    void recur(int level, int param){

        //terminator
        if (level > MAX_LAVEL) {
            //process result
            return;
        }

        //process current logic
        process(level,param);

        //drill down
        int newParam = param++;
        recur(level+1,newParam);

        //restore current status
    }

    private void process(int level, int param) {
    }
}
