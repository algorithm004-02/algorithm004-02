/*
    190. 颠倒二进制位
    颠倒给定的 32 位无符号整数的二进制位。
*/

// 解法1: 移位操作
public class Solution
{
    public uint reverseBits(uint n)
    {
        uint ans = 0;
        for (uint i = 0; i < 32; i++)
        {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}