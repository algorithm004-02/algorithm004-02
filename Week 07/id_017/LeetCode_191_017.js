
/**
 * 191.位1的个数
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {

    //1.for loop 0-->32
    //2. %2, /2
    //3. &1, x = x >> 1;
    //4. n & (n-1) 清零最低位的1
    // 时间复杂度：O(1)(最坏情况下n中所有位均为1)
    // 空间复杂度：O(1)
    // 每次把数字最后一个二进制位1反转为0，count++
    // 当没有1可反的时候，数字变成了0
    // n & (n-1)
    // 清零最低位的1
    let count = 0;
    while(n != 0) {
       count++;
       n &= (n-1); //n = n & (n-1)
    }
    return count;
};