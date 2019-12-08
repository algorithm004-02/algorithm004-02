/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false
    let map = new Map()
    for(let i in s){
        if(map.has(s[i])) {
            let count = map.get(s[i])
            map.set(s[i], count + 1)
        } else {
            map.set(s[i], 1);
        }
    }

    for(let i in t) {
        if(map.has(t[i])) {
            let count = map.get(t[i])
            map.set(t[i], count -1 )
        } else {
            return false
        }
    }
    

    for(let v of map.values()) {
        if(v !== 0) return false 
    }

    return true;
};