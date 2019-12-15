/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
    if (s[0] == 0) {
        return 0
    }
    let n = s.length
    let dp = new Array(n + 1).fill(0)
    dp[0] = dp[1] = 1
    for (let i = 2; i <= n; i++) {
        if (s[i-1] != 0){
            dp[i] += dp[i -1]
        }
        if ((s[i-2] == 1) || (s[i-2] == 2 && s[i-1] <=6)){
            dp[i] += dp[i-2]
        }
    }
    return dp[n]

};


var numDecodings = function (s) {
    if (s[0] == 0){
        return 0
    }
    let n = s.length
    let memo = new Map()
    let helper = (start)=>{
        if (start == n){
            return 1
        }
        if (s[start] == 0){
            return 0
        }
        let memoVal = memo.get(start)
        if (memoVal){
            return memoVal
        }
        let odd = helper(start + 1,memo)
        let even = 0
        if(start < n -1){
            let ten = s[start]
            let one = s[start + 1]
            if((ten +'' + one) < 27){
                even = helper(start + 2,memo)
            }
        }
        let res = odd + even
        memo.set(start,res)
        return res
    }
    return helper(0,memo)
};

