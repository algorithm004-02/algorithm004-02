/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {  
    const m = new Map();
    
    for(const s of strs) {
        const keys = Array(26).fill(0);
        for(const c of s){
            ++keys[c.charCodeAt(0) - 97]
        }
        const key = keys.join("#");
        let val = [];
        if(m.has(key)) {
            val = m.get(key)
        }  
        val.push(s);
        m.set(key, val);
    }
 
    return Array.from(m.values());
};