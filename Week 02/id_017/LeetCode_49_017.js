

/**  
 * 49.字母异位词分组
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    // 通过排序 然后判断Map是否存在这个元素，有就加进去，没有就创建新数组
    
    var map = {};
    for (let str of strs) {
        const key = [...str].sort().join('');
        if (!map[key]) {
            map[key] = [];
        }
        map[key].push(str);
    }
    
    return Object.values(map);

};