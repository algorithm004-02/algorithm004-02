//暴力循环法，循环int类型的长度，去判断每一位是否为1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //int 为 32 位长度，所以数组需要循环32位
        int sum = 0;
        int mask = 1;//使用标记  1的最低位为1，之后与目标值逐步对比
        for (int i = 0; i < 32; i++) {//比较 32 位长度
            if ((n & mask) != 0) {
                sum ++;
            }
            mask <<= 1;//将要比较的位数 1，向左移一位，继续比较
        }
        return sum;
    }
}
    //同理，只不过去掉了 mask 变量，而让目标n 每次想左移动一位，进行比较
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //int 为 32 位长度，所以数组需要循环32位
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                sum ++;
            }
            n >>= 1;
        }
        return sum;
    }
}