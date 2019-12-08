/** 22. 括号生成 **/

/**
 * 
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let res = [];
    generate(0, 0, n, '');
    function generate(left, right, n, str) {
        if (left === n && right === n) return res.push(str);
       
        // 剪枝
        if (left < n) generate(left + 1, right, n, str + '(');
        
        if (left > right) generate(left, right + 1, n, str + ')');
    }

    return res;
};