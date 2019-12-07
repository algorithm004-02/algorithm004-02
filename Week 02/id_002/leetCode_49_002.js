/** 49. 字母异位词分组 */

/** 第一种解法 字符串排序后字母异位词。
 * 时间复杂度：O(NK log K)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
 * 空间复杂度：O(NK)
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let map = {};
    
    for (let i = 0; i < strs.length; i++) {
        let str = strs[i];
        let key = str.split("").sort();
        !map[key] ? (map[key] = [str]) : map[key].push(str);
    }
    
    return Object.values(map);
};

/** 第二种种解法 按计数分类， a-z排列成26位，每位统一次数分组。
 * 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 KK 是 strs 中字符串的最大长度
 * 空间复杂度：O(NK)
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams2 = function(strs) {
    let map = {};
    for(let i = 0; i < strs.length; i++) {
        let count = Array(26).fill(0);
        let str = strs[i];
        let base = 'a'.charCodeAt();
    
        for(let j = 0; j < str.length; j++) {
            count[str[j].charCodeAt() - base] += 1;
        }
        
        let key = count.join("");
        !map[key] ? (map[key] = [str]) : map[key].push(str);
    }
    
    return Object.values(map);
};