/** 205. 同构字符串 **/
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    let m1 = Array(256).fill(0);
    let m2 = Array(256).fill(0);

    for (let i = 0; i < s.length; i ++) {
        if (m1[s.charCodeAt(i)] !== m2[t.charCodeAt(i)]) {
            return false;
        }

        m1[s.charCodeAt(i)] = i + 1;
        m2[t.charCodeAt(i)] = i + 1;
    }

    return true;
};