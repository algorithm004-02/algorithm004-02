/**
 * 387.字符串中的第一个唯一字符串
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    if(s.length == 0) return -1;
    //使用hash来存储已有的值
    let hash = {};
    //存储结果
    let map = new Map();
    for(let i = 0; i < s.length; i++) {
        //没有的值就存储进去
        if(!hash[s[i]]) {
            hash[s[i]] = 1;
            map.set(s[i],i);
        }else {
            //删除已有的，已重复不合格了
            map.delete(s[i]);
        }
    }

    if(map.size == 0) return -1;

    return map.values().next().value;

};
