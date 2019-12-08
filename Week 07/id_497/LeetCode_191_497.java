class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n!=0){
            sum++;
            //n-1后n最后一位1变0， 最后一位后的0变1，&后从最后一位开始所有的都变成0，sum++,然后继续直到0
            n &= (n-1);
        }
        return sum;
    }
}