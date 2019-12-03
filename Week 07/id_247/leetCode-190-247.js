/**
 * 190. 颠倒二进制位
    颠倒给定的 32 位无符号整数的二进制位。
    00000010100101000001111010011100 → 00111001011110000010100101000000
    即 43261596 → 964176192
 *
 * https://leetcode-cn.com/problems/reverse-bits/
 * 84 ms , 在所有 javascript 提交中击败了 71.95% 的用户
 */

const reverseBits = ( n ) => {

    let res = 0
    let count = 32

    while (count--) {
        res *= 2
        res += n & 1
        n = n >> 1
    }
    return res
}

const reverseBits2 = ( n ) => {

    let res = 0

    for(let i = 0; i < 32; i++)
    {
        res <<= 1
        res |= n & 1
        n >>= 1
    }

    return res >>> 0;
}
