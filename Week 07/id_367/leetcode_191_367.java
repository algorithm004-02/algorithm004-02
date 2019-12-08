public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32;i++){   //for循环和while 循环两种解法
            if((mask & n) != 0) count++;
            //n) = n & (n - 1);
            mask = mask << 1;
        }
        
        return count;
    }
}
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            //if(n & (n - 1) == 0) return;
            n = n & (n - 1);
        }
        return count;
    }
}