/** 151. 翻转字符串里的单词 **/

// 学习下面几段代码， 熟练使用

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split('');
    let n = arr.length;
    
    // 1. 翻转整个字符串
    reverse(0, n - 1);

    // 2. 翻转单词
    reverseWords();

    //3. 去除空格
    return cleanSpaces();

    function reverseWords() {
        let i = 0; 
        let j = 0;
        
        // 注意理解下端代码 在一个串中， 截取到第一个单词, 然后进行翻转 (学习这段代码)
        while( i < n) {
            while(i < j || i < n && arr[i] === ' ') i ++;
            while(j < i || j < n && arr[j] !== ' ') j ++;
            reverse(i, j - 1);
        }
    }

    function cleanSpaces() {
        let i = 0;
        let j = 0;
        
        // 注意这段代码 把空格的位置替换为字母 (学习这段代码)
        while(j < n) {
            while(j < n && arr[j] === ' ') j ++;
            while(j < n && arr[j] !== ' ') arr[i++] = arr[j++];
            while (j < n && arr[j] == ' ') j++;
            if (j < n) arr[i++] = ' ';
        }

        // 最后字符串截取到i
        return arr.join('').substring(0, i);
    }

    function reverse(i, j) {
        while(i < j) {
            [arr[i ++], arr[j --]] = [arr[j], arr[i]];
        }
    }
};