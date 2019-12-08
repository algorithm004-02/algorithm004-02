1 思路一
	若 n=2x 且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件：
	1、恒有 n & (n - 1) == 0，这是因为： 
	· n 二进制最高位为 1，其余所有位为 0；
	· n−1 二进制最高位为 0，其余所有位为 1；
	2、一定满足 n > 0。
2 暴力求解发，循环若1 的个数 不为 1，则 false， 为1 则 true 

//思路一 最优解
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}