/** 70. 爬楼梯 */
// 1. DP
// 2. DFS + cache

/** 
    1. 1, 2 一步两步
        DP
            a. 重复子问题
                f[i] = f[i - 1] + f[i - 2]
            b. 状态数组定义
                f[i]
            c. DP方程
                f[i] = f[i - 1] + f[i - 2]

    2. 1,2,3 一步两步三步
        DP
            a. 重复子问题
                f[i] = f[i - 1] + f[i - 2] + f[i - 3]
            b. 状态数组
                f[i]
            c. DP方程
                 f[i] = f[i - 1] + f[i - 2] + f[i - 3]

    3. x1, x2, xm... k步
        DP
            a. 重复子问题
                for j Range(len(m)) :
                    a[i] += a[i - m[j]]
            b. 定义状态数组
                f[i]
            c. DP方程
                for j range(len(m))
                    f[i] += f[i - m[j]]
            
    4. 前后不能走相同的步伐
 */

/**
 * DP
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n === 0) return 0;
    if (n === 1) return 1;
    if (n === 2) return 2;

    let f1 = 1;
    let f2 = 2;
    for (let f = 2; f < n; f++) {
        let f3 = f1 + f2;
        [f1, f2] = [f2, f3];
    }    

    return f2;
};

/**
 * DFS + cache
 * 时间复杂度O(N) 空间复杂度O(n)
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let cache = {};
    return dfs(n);

    function dfs(n) {
        if (n <= 0) return 0;

        if (n === 1) return 1;
        if (n === 2) return 2;
       
        if (!Number.isInteger(cache[n - 1])) {
            cache[n - 1] = dfs(n - 1);
        }

        if (!Number.isInteger(cache[n - 2])) {
            cache[n - 2] = dfs(n - 2);
        }

        let f1 = cache[n - 1];
        let f2 = cache[n - 2];

        return f1 + f2;
    }
};