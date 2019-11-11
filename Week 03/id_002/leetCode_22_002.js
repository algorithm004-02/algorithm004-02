/** 22. 括号生成  */

/**
 * 深度优先搜索
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let res = [];

    dfsGenerate(0, 0, n, '');
    
    function dfsGenerate(left, right, n, str) {
        if (left === n && right === n) return res.push(str);
       
        if (left < n) dfsGenerate(left + 1, right, n, str + '(');
        
        if (left > right) dfsGenerate(left, right + 1, n, str + ')');
    }

    return res;
};

/**
 * 广度优先搜索
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis2 = function(n) {
    let res = [];
    let root = {value: '('}
    let queue = [root];
    let level = 0;
    while(queue.length) {
        if(level > n) break;
        
        level ++;

        let node = queue.shift();
        
        node.left = {value: '('};
        node.right = {value: ')'};

        queue.push(node.left, node.right);
    }

    return res;
};