
/**
 * 22.括号生成
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    //递归
   const res = [];

  function _generate(left, right, s) {  
    if (left > right) return; 

    if (left === 0 && right === 0) {
      res.push(s);
      return;
    }

    if (left > 0) _generate(left - 1, right, s + '(');
    if (right > 0) _generate(left, right - 1, s + ')');
  }

  _generate(n, n, '');
  return res;
    
};
