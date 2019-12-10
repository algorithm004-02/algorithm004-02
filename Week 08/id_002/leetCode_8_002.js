/**  **/
// js 最大整形是2^53  leetCode 最大为数为32 取值范围 -2^32 ~ 2^32 - 1 同时存在多个正负号时sign 为 0

/* test 
" ++1"
"+++--2"
"42"
"   -42"
"4193 with words"
"words and 987"
"-91283472332"
*/
/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    let len = str.length;
    let index = 0;
    let sign = 1;
    let total = 0;
    
    // 记录是否有多余的符号 存在 + - 号时 为sign = 0
    let signC = {'+': 0, '-':  0};
   
    // remove spaces
    while(index < len && str[index] == ' ') {
        index ++;
    }

    // handle signs
    while(index < len && (str[index] === '+' || str[index] === '-')) {
        // 这里如果存在++ -- +- 等多个符号 sign = 0
        if (str[index] === '+') {
            sign = (signC['-'] > 0 || ++ signC['+'] > 1) ? 0 : 1;
        }

        if (str[index] === '-') {
            sign = (signC['+'] > 0 || ++ signC['-'] > 1) ? 0 : - 1;
        }

        index ++;
    }

       
    // Convert number and avoid overflow
    while(index < len) {
        let code = str.charCodeAt(index);
        if (code < 48 || code > 57) break;

        total = total * 10 + (code - 48);
        if (total >= Math.pow(2, 31)) {
            return sign * (sign > 0 ? Math.pow(2, 31) - 1 : Math.pow(2, 31));
        }

        index ++;
    }

    return sign * total;
};

