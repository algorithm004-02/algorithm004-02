/**
 * @param {string} s
 * @return {number}
 */

// DP
var longestValidParentheses = function(s) {
    let max = 0;
    let dp = [0];
    for(let current = 1; current<s.length; current++) {
        const previous = current -1;
        const previousClosed = current - 2;
        const chainBegin = current - dp[current -1];
        const betweenChains = chainBegin - 1;
        const previousChainEnd = current - dp[current - 1] - 2;

        if(s[current] === ")") {
            if(s[previous] === "(") {
                dp.push(current >=2? dp[previousClosed] + 2 : 2);
            } else if (s[betweenChains] === "(") {
                dp.push(dp[previous] + (chainBegin >= 2 ? dp[previousChainEnd] + 2 : 2));
            } else {
                dp.push(0);
            }
            dp.push(0);
        }
        max = Math.max(max, dp[current]);

    }
    return max;
}