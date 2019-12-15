/*
    191. 位1的个数
*/

// 解法1: 利用逻辑与运算.
// n & (n - 1) 会将n最低位的1清零. 因此只要不断将 n 最低位的1清零, 直到n变为0, 循环次数即位1的个数.
public class Solution
{
    public int HammingWeight(uint n)
    {
        int bits = 0;
        while (n != 0)
        {
            bits++;
            n &= (n - 1);
        }
        return bits;
    }
}