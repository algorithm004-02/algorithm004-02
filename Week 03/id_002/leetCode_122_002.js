/** 122. 买卖股票的最佳时机 II **/

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let maxProfit = 0;
    
    prices.forEach((price, index) => {
        if (index === 0) return;
        
        if (price > prices[index - 1]) {
            maxProfit += (price - prices[index - 1]);
        }
    })
    
    return maxProfit;
};