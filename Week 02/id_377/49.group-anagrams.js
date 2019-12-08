/*
 * @lc app=leetcode id=49 lang=javascript
 *
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
// ------------------------- 解法 1 start --------------------------
// 最好记  👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
// var groupAnagrams = function(strs) {
//     strs = strs.sort();
//     var mapping = {};
//     for (var i = 0; i < strs.length; i++) {
//         var str = strs[i];
//         var sorted = str.split('').sort().join('');
        
//         if (mapping[sorted] === undefined) {
//             mapping[sorted] = [str];
//         } else {
//             mapping[sorted].push(str);
//         }
//     }
    
//     var output = [];
//     for (var arr in mapping) {
//         output.push(mapping[arr]);
//     }
    
//     return output;
// };
// --------ES6-------------- 解法 2 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘
// const getKey = (str) => [...str].sort().join('');
// const groupAnagrams = (strs) => Object.values([...strs].reduce((result, str) => {
//    const key = getKey(str);
//    if (!result[key]) {
//         result[key] = [str];
//     } else {
//         result[key].push(str);
//     }
//     return result;
// }, {}));

// ------------------------- 解法 3 start --------------------------
// 最好记  👍 👍 👍 👍 👍
// 最优解  😘 😘 😘 😘 😘
// var groupAnagrams = function(strs) {
//     if (!strs || strs.length == 0) return [];
//     let key;
//     let map = new Map();
//     for (let i = 0; i < strs.length; i++) {
//         key = [...strs[i]].sort().join('');
//         if (map.has(key)) {
//             map.get(key).push(strs[i]);
//         } else {
//             map.set(key, [strs[i]]);
//         }
//     }
//     return [...map.values()];
// };


var groupAnagrams = function(strs) {
    let resultMap = new Map()
    strs.map(e => {
        let str = [...e].sort().join('')
        if (resultMap.has(str)) {
            let arr = resultMap.get(str)
            arr.push(e)
            resultMap.set(str, arr)
        } else {
            resultMap.set(str, [e])
        }
    })
    return [...resultMap.values()]
};


// @lc code=end

