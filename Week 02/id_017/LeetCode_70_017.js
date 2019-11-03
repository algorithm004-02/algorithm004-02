

/**
 * 70.爬楼梯
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    //解法1
    // 暴力循环
    
    
    //解法2
    //第一步 边界条件
    if(n < 3) {
        return n;
    }
    //第二步 写出斐波拉契迭代公式
    var f1 = 1, f2 = 2, f3 = 3;
    for(var i = 3; i < n+1; ++i) {
        f3 = f1 + f2;
        f1 = f2;
        f2 = f3;
    }
    
    return f3;
};