/** 438. 找到字符串中所有字母异位词 **/

// 1. 滑动窗口问题

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var findAnagrams = function(s, p) {
    let needs = new Map();
    let win = new Map();

    for(let c of p) {
        if (!needs.has(c)) {
            needs.set(c, 1);
        } else {
            needs.set(c, needs.get(c) + 1);
        }
    }

    let start = 0, end = 0, match = 0, res = [];

    while(end < s.length) {
        let c1 = s[end];
        if (!win.has(c1)) {
            win.set(c1, 1);
        } else {
            win.set(c1, win.get(c1) + 1);
        }

        if(win.get(c1) === needs.get(c1)) {
            match ++;
        }

        end ++;

        while(match === needs.size) {
            if (end - start === p.length) {
                res.push(start);
            }

            let c2 = s[start];
            if (needs.has(c2)) {
                win.set(c2, win.get(c2) - 1);

                if (win.get(c2) < needs.get(c2)) {
                    match --;
                }
            }

            start ++;
        }
    }
    return res;
}