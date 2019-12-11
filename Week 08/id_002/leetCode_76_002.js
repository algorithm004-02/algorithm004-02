/** 76. 最小覆盖子串 **/

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    let needs = new Map();
    let window = new Map();

    for (let c of t) {
        if(needs.has(c)) {
            needs.set(c, needs.get(c) + 1);
        } else {
            needs.set(c, 1);
        }
    }

    let start = 0; 
    let end = 0;
    let match = 0;
    let minLen = Number.MAX_SAFE_INTEGER;
    let minStart = 0;

    while(end < s.length) {
        let c1 = s[end];
        if (!window.has(c1)) {
            window.set(c1, 1);
        } else {
            window.set(c1, window.get(c1) + 1);
        }

        if (needs.has(c1) && window.get(c1) === needs.get(c1)) {
            match ++;
        }
        end ++;

        while(match === needs.size) {
            if (end - start < minLen) {
                minLen = end - start;
                minStart = start;
            }         
            
            let c2 = s[start];
            if (needs.has(c2)) {
                window.set(c2, window.get(c2) - 1);
                if (window.get(c2) < needs.get(c2)) {
                    match --;
                }
            }

            start ++;
        }
    }

    return minLen === Number.MAX_SAFE_INTEGER ? "" : s.substring(minStart, minStart + minLen);
};