/** 771. 宝石与石头 **/

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    let ans = 0;
    let setN = new Set();
    for (let j of J) {
        setN.add(j);
    }

    for (let s of S) {
        if (setN.has(s)) {
            ans ++;
        }
    }

    return ans;
};