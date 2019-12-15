/**
 * 746. 使用最小花费爬楼梯
     数组的每个索引做为一个阶梯，第?i个阶梯对应着一个非负数的体力花费值?cost[i](索引从0开始)。
     每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     cost = [10, 15, 20] → 15
     cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] → 6
 *
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * 1. 84 ms , 在所有 javascript 提交中击败了 23.90% 的用户
 * 2. 72 ms , 在所有 javascript 提交中击败了 72.20% 的用户
 */

const minCostClimbingStairs = (cost) => {

    const dp = []
    dp[0] = cost[0]
    dp[1] = cost[1]
    const n = cost.length

    for (let i = 2; i < n; i++) {
        dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i]
    }

    return dp[n - 1] > dp[n-2] ? dp[n-2] : dp[n-1]
}

const minCostClimbingStairs2 = (cost) => {

    const dp = []
    dp[0] = cost[0]
    dp[1] = cost[1]
    cost.push(0)
    const n = cost.length

    for (let i = 2; i < n; i++) {
        dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i]
    }

    return dp[n - 1]
}


let cost = [0,0,0,1]
console.log( minCostClimbingStairs2(cost) )