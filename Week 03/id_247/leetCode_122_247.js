/**
 * 122. 买卖股票的最佳时机 II
 给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 [7,1,5,3,6,4] -> 7,  [1,2,3,4,5] -> 4,  [7,6,4,3,1] -> 0
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 1. 只有多了就加起来:  68 ms , 在所有 javascript 提交中击败了 89.22% 的用户
 */

const maxProfit = (prices) => {

    let max = 0

    for (let i = 1; i < prices.length; i++) {

        if (prices[i] > prices[i-1])
            max += prices[i] - prices[i-1]
    }
    return max
}