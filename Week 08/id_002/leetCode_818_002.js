/** 818. 赛车 **/

// 1. BFS
// 2. DP
// 3. DFS
//      a. 重复子问题
//          状态： 
//              1. 到达位置i前
//  
//                  正方向加速：
//                      j 正方向加速位置(也可以说加速到距离)（1<= j < i）
//                      cnt1 正方向加速次数 j = 2^cnt1 - 1
//                  
//                  反方向加速：
//                      k 反方向加速位置 (0 <= k < j)
//                      cnt2 反方向加速次数 k = 2^cnt2 - 1
//                  
//                   公式：
//                      dp[i] = 正方向加速指令cnt1 + R(1) + 反方向加速指令cnt2 + R(1) + dp(i - (j - k))
//                      dp[i] = cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)]
//
//                  迭代每次正向加速到的位置j进行反向加速k
//                  for(j = 1, cnt1 = 1; j < i; j = (1 << ++ctn1) - 1)) 
//                      for(k = 0, cnt2 = 0; i < j; k = (1 < ++ctn2) - 1)
//                          dp[i] = min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)])
//                                 
//              2. 到达位置之后及刚到i
//                   j === i ? ctn1 : cnt1 + 1 + dp[j - i]
//              3. 总结：
//                  for(j = 1, cnt1 = 1; j < i; j = (1 << ++ctn1) - 1)) 
//                      for(k = 0, cnt2 = 0; i < j; k = (1 << ++ctn2) - 1)
//                          dp[i] = min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)])
//
//                  dp[i] = min(dp[i], i === j ? ctn1 : ctn1 + 1 + dp[j - i])
//              
//      b. 定义状态数组
//          dp[i] 
//             i 位置的最短指令长度
//      c. dp方程
//          for(j = 1, cnt1 = 1; j < i; j = (1 << ++ctn1) - 1)) 
//              for(k = 0, cnt2 = 0; i < j; k = (1 << ++ctn2) - 1)
//                  dp[i] = min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)])
//
//          dp[i] = min(dp[i], i === j ? ctn1 : ctn1 + 1 + dp[j - i])
// 参考：https://www.cnblogs.com/grandyang/p/10360655.html

/**
 * 1. BFS 
 * 时间复杂度O(2^k) 空间复杂度O(n)
 * @param {number} target
 * @return {number}
 */
var racecar = function(target) {
    let queue = [[0, 1]];
    let visited = new Set(['0,1']);
    let res = 0;

    while(queue.length) {
        let tmp = [];
        for (let i = 0; i < queue.length; i ++) {
            let [posi, speed] = queue[i];
            if (posi == target) return res;
            
            // A 加速 
            let newP = posi + speed, newS = speed * 2;
            addQueue(newP, newS, tmp);
            
            // R 开始变换方向
            newP  = posi, newS = speed > 0 ? -1 : 1;
            addQueue(newP, newS, tmp);
        }
       
        res ++;
        queue= tmp;
    }

    return -1;
    
    function addQueue(posi, speed, tmp) {
        let key = `${posi},${speed}`;
        if (!visited.has(key) && posi > 0 && posi < 2 * target) {
            visited.add(key);
            tmp.push([posi, speed]);
        }
    }
};

/**
 * 时间复杂度O(TlogT) 空间复杂度O(T)
 * @param {number} target
 * @return {number}
 */
var racecar = function(target) {
    let dp = [];
    for(let i = 1; i <= target; i++) {
        dp[i] = Number.MAX_VALUE;
        let j = 1, cnt1 = 1;
        for (; j < i; j = (1 << ++cnt1) - 1) {
            for (let k = 0, cnt2 = 0; k < j; k = (1 << ++cnt2) - 1) {
                dp[i] = Math.min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)]);
            }
        }

        dp[i] = Math.min(dp[i], cnt1 + (i == j ? 0 : 1 + dp[j - i]))
    }

    return dp[target];
};

/**
 * DFS 
 * @param {number} target
 * @return {number}
 */
var racecar = function(target) {
    let dp = Array(target + 1).fill(-1);
    dp[0] = 0;
    
    return dfs(target);
    function dfs(i) {
        if (dp[i] >= 0) return dp[i];

        dp[i] = Number.POSITIVE_INFINITY;

        let j = 1, cnt1 = 1;
        for (; j < i; j = (1 << ++cnt1) - 1) {
            for(let k = 0, cnt2 = 0; k < j; k = (1 << ++cnt2) - 1) {
                dp[i] = Math.min(dp[i], cnt1 + 1 + cnt2 + 1 + dfs(i - (j - k)));
            }
        }

        dp[i] = Math.min(dp[i], (i === j) ? cnt1 : cnt1 + 1 + dfs(j - i));
        
        return dp[i];
    }
};