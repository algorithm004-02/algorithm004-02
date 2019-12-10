/** 541. 反转字符串 II **/
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) { 
    //由于JavaScript 字符串是immutable 所以尽量使用库函数前提下完成字符串的交换操作
    let arr = s.split('');
    let len = arr.length;

    let i = 0; 
    while( i < len) {
        let j = Math.min(i + k - 1, len - 1);
        swap(i, j);
        i += 2 * k;
    }
    
    return arr.join('');
    
    // 交换位置
    function swap(i, j) {
        while(i < j) {
            [arr[i ++], arr[j --]] = [arr[j], arr[i]];
        }
    }
};