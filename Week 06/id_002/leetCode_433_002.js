
/** 433. 最小基因变化 **/

/**
 * BFS
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    let bankSet = new Set(bank);
    let queue = [[start, 0]];
    
    if (!bankSet.has(end)) return - 1;

    while(queue.length) {
        let [cur, dep] = queue.shift();
        if (cur === end) return dep;
        
        let gener = mulGenerator(cur);
        for (let dna of gener) {
            if (bankSet.has(dna)) {
                bankSet.delete(dna);
                queue.push([dna, dep + 1]);
            }
        }
    }
    
    return -1;
    
    function * mulGenerator(mul) {
        let DNA = ['A', 'G', 'C', 'T'];
        for (var i = 0; i < mul.length; i++) {
            for (var m of DNA) {
                if (mul[i] === m) continue;
                yield mul.substr(null, i) + m + mul.substr(i + 1);
            }
        }
    }
};

/**
 * 双向BFS
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    let bankSet = new Set(bank);
    let startSet = new Set([start]);
    let endSet = new Set([end]);
    if (!bankSet.has(end)) return - 1;

    let dep = 0;
    while(startSet.size && endSet.size) {
        let tmp = new Set();
        for (var cur of startSet) {
            for (var dna of mulGenerator(cur)) {
                if (endSet.has(dna)) return dep + 1;

                if (bankSet.has(dna)) {
                    bankSet.delete(dna);
                    tmp.add(dna);
                }
            }
        }
        
        startSet = tmp;
        dep ++;

        if (startSet.size > endSet.size) {
            [startSet, endSet] = [endSet, startSet];
        }
    }
    
    return  -1;

    function * mulGenerator(mul) {
        let DNA = ['A', 'G', 'C', 'T'];
        for (var i = 0; i < mul.length; i++) {
            for (var m of DNA) {
                if (mul[i] === m) continue;
                yield mul.substr(null, i) + m + mul.substr(i + 1);
            }
        }
    }
};