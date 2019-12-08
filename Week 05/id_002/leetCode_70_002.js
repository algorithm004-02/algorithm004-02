/** 70. 爬楼梯 **/
/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number} n
 * @return {number}
 */
var climbStairs1 = function(n) {
    let f1 = 1;
    let f2 = 2;
    let f3 = f1 + f2;
    
    if (n === 0) return 0;
    if (n === 1) return f1;
    if (n === 2) return f2;
    
    for(var i = 2; i < n ; i++) {
        f3 = f1 + f2;
        [f1, f2] = [f2, f3];
    }
    
    return f3;
};

/**
 * 递归 
 * 时间复杂度O(2^n) 空间复杂度O(n)
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    return dfs(n);
    function dfs(n) {
        if (n <= 0)  return 0;
        if (n === 1) return 1;
        if (n === 2) return 2;
        
        return dfs(n - 1) + dfs(n - 2);
    }
};


/**
 * 递归 记忆搜索
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let cache = {};
    
    return dfs(n);
    function dfs(n) {
        if (n <= 0)  return 0;
        if (n === 1) return 1;
        if (n === 2) return 2;
        
        
        var f1 = cache[n -1];
        var f2 = cache[n - 2];
        
        if (!Number.isInteger(f1)) {
            f1 = dfs(n - 1);
            cache[n - 1] = f1;
        }
        
        if (!Number.isInteger(f2)) {
            f2 = dfs(n - 2);
            cache[n - 2] = f2;
        }
        
        return f1 + f2;
    }
};