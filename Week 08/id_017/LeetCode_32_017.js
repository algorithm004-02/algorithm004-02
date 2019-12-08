/**
 * 32.最长有效括号
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    //分治 
    //状态定义
    //DP方程

    if(s.length <= 1) return 0;
    var curMax = 0;
    //声明元素为整型的数组
    var longest = new Array(s.length).fill(0);
    for(let i = 1; i < s.length; i++) {
         if(s[i] == ')') {
            if(s[i-1] == '('){
                longest[i] = (i-2) >= 0 ? (longest[i-2] + 2) : 2;
                curMax = Math.max(longest[i],curMax);
            }
            else{ // if s[i-1] == ')', combine the previous length.
                if(i-longest[i-1]-1 >= 0 && s[i-longest[i-1]-1] == '('){
                    longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                    curMax = Math.max(longest[i],curMax);
                }
            }
         }
         //else if s[i] == '(', skip it, because longest[i] must be 0
    }

     return curMax;
};
