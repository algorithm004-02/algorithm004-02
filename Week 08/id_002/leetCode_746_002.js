/** 746. 使用最小花费爬楼梯 **/
// 1.DP
//      a. 重复字问题
//          cost[i] = min(cost[i - 1], cost[i - 2]) + arr[i]
//      b. 定义状态数组
//          f[i]
//      c. dp方程
//          f[i] = min(f[i - 1], f[i - 2]) + arr[i]

// 2. DFS + cache

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    let len = cost.length;

    let f1 = cost[0];
    let f2 = cost[1];
    
    for(let f = 2; f < len; f ++) {h
        let f3 = cost[f] + Math.min(f1, f2);
        [f1, f2] = [f2, f3];
    }

    return Math.min(f2, f1);
};

/**
 * 2. DFS + cache
 * 时间复杂度为O(n), 空间复杂度O(n)
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    let len = cost.length;
    let cache = {};

    return dfs(len - 1);

    function dfs(n, f) {
        if (n <= 0) return cost[0];
        if (n === 1) return cost[1];

        let f1
        if (!Number.isInteger(cache[n - 2])) {
            cache[n - 2] = dfs(n - 2);
        }

        if (!Number.isInteger(cache[n - 1])) {
            cache[n - 1] = dfs(n - 1);
        }

        f1 = cache[n - 2];
        f2 = cache[n - 1];

        let f3 = Math.min(f1, f2) + cost[n];

        if (n === len - 1) {
            return Math.min(f2, f3)
        }
       
        return f3;
    }
};