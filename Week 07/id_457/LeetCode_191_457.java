/**
 * 191. 位1的个数
 */
public class Solution {
    //循环和位移动
    // public int hammingWeight(int n) {
    //     int bits = 0;
    //     int mask = 1;
    //     for (int i = 0; i < 32; i++) {
    //         if ((n & mask) != 0) {
    //             bits++;
    //         }
    //         mask <<= 1;
    //     }
    //     return bits;
    // }
    
    //位操作
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n-1);
        }
        return sum;
    }
}