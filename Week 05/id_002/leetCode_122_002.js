/** 121. 买卖股票的最佳时机 **/

// DP: (不考虑交易次数, 尽可能完成更多交易)
//     a. 重复子问题
//         max_profrit[i][0] = Max(max_profrit[i - 1][1] + prices[i], max_profrit[i - 1][0])
//         max_profrit[i][1] = Max(max_profrit[i - 1][0] - prices[i], max_profrit[i - 1][1])
//     b. 定义状态数组
//         f[i] = [0, 1]
//         0: 不持有股票
//         1: 持有股票
//     c. DP方程
//         f[i][0] = Max(f[i - 1][1] + prices[i], f[i - 1][0])
//         f[i][1] = Max(f[i - 1][0] - prices[i], f[i - 1][1])


