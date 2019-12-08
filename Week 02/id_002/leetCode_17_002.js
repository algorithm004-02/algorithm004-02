/** 17. 电话号码的字母组合 **/

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    let res = [];
    let len = digits.length;
    let map = {
        2:"abc",
        3:"def",
        4:"ghi",
        5:"jkl",
        6:"mno",
        7:"pqrs",
        8:"tuv",
        9:"wxyz"
    }
    generate(0, 0, '');
    return res;
    function generate(dep, i, str) {
        if (dep >= len) return res.push(str);  
        let letter = map[digits[i]];
        for(let j = 0; j < letter.length; j++) {
            generate(dep + 1, i + 1, str + letter[j]);
        }
    }
};

/**
 * 迭代法 
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations2 = function(digits) {
    if (digits.length === 0) return [];
    
    let map = {
        2:"abc",
        3:"def",
        4:"ghi",
        5:"jkl",
        6:"mno",
        7:"pqrs",
        8:"tuv",
        9:"wxyz"
    }
    
    let res = [''];
    for (let digit of digits) {
        if (!map[digit]) continue;
        
        let curAns = [];
        for (let letter of map[digit]) {
            res.forEach((word) => curAns.push(word+letter));
        }
        
        res = curAns;
    }
    
    return res;
};