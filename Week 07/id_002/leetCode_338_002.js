/** 338. 比特位计数  **/

// 1. for loop 对每一 i while(i) i & (i - 1) 进行统计
// 2. 动态规划 + 最低有效位
// 3. 动态规划 + 最后设置位

/**
 * 时间复杂度O(nk) 控件复杂度O(n)
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let ans = [];
    for(let i = 0; i <= num; i ++) {
        ans.push(popcount(i));
    }  

    return ans;
    
    function popcount(i) {
        let count = 0;
        while(i) {
            count ++;
            i &= (i - 1);
        }
        
        return count;
    }
};

// DP
//      a. 重复子问题
//          count[i] = count[i >> 1] + (i & 1)
//      b. 定义状态数组
//          f[i]
//      c. DP方程
//          f[i] = f[i >> 1] + (i & 1)

/**
 * 1. 动态规划 + 最低有效位
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let ans = [0];
    for(let i = 1; i <= num; i ++) {
        ans.push(ans[i >> 1] + (i & 1));
    }  

    return ans;
};

// DP
//      a. 重复子问题
//          count[i] = count[i & (i - 1)] + 1
//      b. 定义状态数组
//          f[i]
//      c. DP方程
//          f[i] = f[i & (i - 1)] + 1
/**
 * 3.动态规划 + 最后设置位
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
    let ans = [0];
    for(let i = 1; i <= num; i ++) {
        ans.push(ans[i & (i - 1)] + 1);
    }  

    return ans;
};



