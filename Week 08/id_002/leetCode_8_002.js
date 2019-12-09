/**  **/
// js 最大整形是2^53  leetCode 最大为数为32 取值范围 -2^32 ~ 2^32 - 1 同时存在多个正负号时sign 为 0

/*
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
    let index = 0, sign = 1, total = 0;
    let count = {'-': 0, '+': 0};

    // remove spaces
    while(index < len && str[index] === ' ') {
        index ++;
    }

    // handle signs
    while(index < len && (str[index] === '+' || str[index] === '-')) {
        if (str[index] === '+') {
            sign = (count['-'] > 0 || ++ count['-'] > 1) ? 0 : 1;
        } 

        if (str[index] === '-') {
            sign = (count['+'] > 0 || ++ count['-'] > 1) ? 0 : -1; 
        }

        index ++;
    }

    // Convert number and avoid overflow
    while(index < len) {
        let digit = str[index];
        let code = digit.charCodeAt();

        // digit 0-9
        if (code < 48 || code > 57) break;

        //if(!Number.isSafeInteger(total * 10 + (digit - 0))) {
        //    return sign > 0 ? Number.MAX_SAFE_INTEGER : Number.MIN_SAFE_INTEGER;        
        //}

        total = total * 10 + (digit - 0);
        index ++;

        if (total >= Math.pow(2, 31)) {
            return sign > 0 ? sign * (Math.pow(2, 31) - 1) : sign * (Math.pow(2, 31));
        }
    }

    return sign * total;
};